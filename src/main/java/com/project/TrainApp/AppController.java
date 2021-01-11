package com.project.TrainApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class AppController {

    TrainRepository trainRepository;
    StationRepository stationRepository;
    RouteRepository routeRepository;

    @Autowired
    public AppController(TrainRepository trainRepository,StationRepository stationRepository,RouteRepository routeRepository) {
        this.trainRepository = trainRepository;
        this.stationRepository = stationRepository;
        this.routeRepository = routeRepository;
        List<Train> trains = new ArrayList<Train>();
        List<Station> stations = new ArrayList<Station>();
        List<Station> stations1 = new ArrayList<Station>();
        List<Station> stations2 = new ArrayList<Station>();
        List<Station> stations3 = new ArrayList<Station>();
        List<Station> stations4 = new ArrayList<Station>();
        List<Station> stations5 = new ArrayList<Station>();
        List<Station> allStations = new ArrayList<Station>();

        Station sArad = new Station(1, "Arad", 21.33, 46.19);
        Station sTimisoara = new Station(2, "Timisoara", 21.21, 45.75);
        Station sOradea = new Station(3, "Oradea", 21.94, 47.07);
        Station sAlba = new Station(4, "Alba", 23.58, 46.06);
        Station sSibiu = new Station(5, "Sibiu",  24.16 ,45.80);
        Station sBucuresti = new Station(6, "Bucuresti", 26.07, 44.45);
        Station sDeva = new Station(7, "Deva", 22.91, 45.88);
        Station sSatuMare = new Station(8, "SatuMare", 22.89, 47.80);
        Station sConstanta = new Station(9, "Constanta", 28.63, 44.17);

        stationRepository.save(sArad);
        stationRepository.save(sAlba);
        stationRepository.save(sBucuresti);
        stationRepository.save(sSibiu);
        stationRepository.save(sDeva);
        stationRepository.save(sConstanta);
        stationRepository.save(sOradea);
        stationRepository.save(sTimisoara);
        stationRepository.save(sSatuMare);

        allStations.add(sSatuMare);
        allStations.add(sOradea);
        allStations.add(sArad);
        allStations.add(sTimisoara);
        allStations.add(sDeva);
        allStations.add(sAlba);
        allStations.add(sSibiu);
        allStations.add(sBucuresti);
        allStations.add(sConstanta);

        stations.add(sTimisoara);
        stations.add(sArad);
        stations.add(sOradea);

        stations1.add(sTimisoara);
        stations1.add(sArad);

        stations2.add(sBucuresti);
        stations2.add(sSibiu);
        stations2.add(sDeva);
        stations2.add(sTimisoara);

        stations3.add(sOradea);
        stations3.add(sArad);
        stations3.add(sTimisoara);
        stations3.add(sDeva);
        stations3.add(sSibiu);

        stations4.add(sDeva);
        stations4.add(sAlba);
        stations4.add(sSibiu);

        stations5.add(sOradea);
        stations5.add(sBucuresti);

        Route sTimisoara_sArad = new Route(1, stations1, "02.12.2020", "13:00");
        Route sTimisoara_sOradea = new Route(2, stations, "03.12.2020", "05:00");
        Route sBucuresti_sTimisoara = new Route(3, stations2, "31.02.2021", "15:30");
        Route sSatuMare_sConstanta = new Route(4, allStations, "07.11.2020", "08:47");
        Route sOradea_sBucuresti = new Route(5, stations5, "17.01.2021", "17:55");
        Route sDeva_sSibiu = new Route(6, stations4, "22.12.2020", "14:15");
        Route sOradea_sSibiu = new Route(7, stations3, "19.11.2020", "23:30");

        routeRepository.save(sTimisoara_sArad);
        routeRepository.save(sTimisoara_sOradea);
        routeRepository.save(sBucuresti_sTimisoara);
        routeRepository.save(sSatuMare_sConstanta);
        routeRepository.save(sOradea_sBucuresti);
        routeRepository.save(sDeva_sSibiu);
        routeRepository.save(sOradea_sSibiu);

        Train train = new Train(1, sTimisoara_sArad, 70, 2, 10, "52min", "13:00", "13:52", "IRN");
        Train train1 = new Train(2, sTimisoara_sOradea, 154, 4, 15, "4h", "05:00", "09:00", "IR");
        Train train2 = new Train(3, sBucuresti_sTimisoara, 114, 3, 20, "6h", "15:30", "20:30", "IR");
        Train train3 = new Train(4, sSatuMare_sConstanta, 260, 6, 50, "10h", "08:47", "18:47", "IR");
        Train train4 = new Train(5, sOradea_sBucuresti, 180, 4, 35, "7h", "17:55", "00:55", "IRN");
        Train train5 = new Train(6, sDeva_sSibiu, 94, 2, 15, "50min", "14:15", "15:05", "IR");
        Train train6 = new Train(7, sOradea_sSibiu, 200, 5, 40, "4h-30min", "23:30", "03:00", "IR");

        trainRepository.save(train);
        trainRepository.save(train1);
        trainRepository.save(train2);
        trainRepository.save(train3);
        trainRepository.save(train4);
        trainRepository.save(train5);
        trainRepository.save(train6);

        trains.add(train);
        trains.add(train1);
        trains.add(train2);
        trains.add(train3);
        trains.add(train4);
        trains.add(train5);
        trains.add(train6);


    }
    @GetMapping("/SearchTrain")
    public List<Train> SearchTrain (@RequestBody SearchTrainRequest searchTrainRequest)
    {
        return TrainAppApplication.SearchByStation(searchTrainRequest.getDeparture(),searchTrainRequest.getArrival(),searchTrainRequest.getDate());
    }

    @GetMapping("/Trains")
    public List<SearchTrainRequest> Train ()
    {
        List<Train> trainList = trainRepository.findAll();
        List<SearchTrainRequest> sTrainList = new ArrayList<>();
        for (Train train : trainList)
        {
            String date = train.getRoute().getDate();
            String arrival = train.getRoute().getStations().get(0).getName();
            String departure = train.getRoute().getStations().get(train.getRoute().getStations().size()-1).getName();
            SearchTrainRequest sTrain = new SearchTrainRequest(train.getId(), departure, arrival, date);
            sTrainList.add(sTrain);
        }
        return sTrainList;
    }

    @GetMapping("/TrainInfo/{id}")
    public Train TrainInfo (@PathVariable("id") int id)
    {
        for (Train train: trainRepository.findAll())
        {
            if(train.getId()==id)
                return train;
        }
        return null;
    }

    @GetMapping("/SearchRoute/{id}")
    public RouteVector SearchRoute (@PathVariable("id") int id)
    {
        boolean first=true;
        String from="";
        String to="";
        double lon=0;
        double lat=0;
        List<List<Double>> listOfDouble=new ArrayList<>();
        List<List<List<Double>>> listOfLists=new ArrayList<>();

        for (Train train: trainRepository.findAll())
        {
            if(train.getId()==id)
            {
                for (Station station :train.getRoute().getStations())
                {
                    if(first)
                    {
                        from=station.getName();
                    }
                    lat=station.getLat();
                    lon=station.getLon();
                    first=false;
                    to=station.getName();
                    List<Double> list=new ArrayList<>();
                    list.add(lon);
                    list.add(lat);
                    listOfDouble.add(list);
                }
                listOfLists.add(listOfDouble);
                Geometry geometry=new Geometry(listOfLists);
                Property property= new Property(to,from);
                Feature feature=new Feature(property,geometry);
                List<Feature> listOfFeatures=new ArrayList<>();
                listOfFeatures.add(feature);
                RouteVector routeVector=new RouteVector( listOfFeatures);
                return routeVector;
            }
        }
        return null;
    }


    @GetMapping("/TrainRoute/{id}")
    public Route TrainRoute (@PathVariable("id") int id)
    {
        for (Train train: TrainAppApplication.trains)
        {
            if(train.getId()==id)
                return train.getRoute();
        }
        return null;
    }

}
