package service;

import model.Manset;
import model.Mgm;
import model.Sehir;

import java.util.List;

public interface IXmlService {

    Mgm getMgm(String url);
    List<Sehir> getSehirler(String url);
    List<Manset> getHaberler(String url);
}
