package ru.gb.jseminar.data;

import java.util.Map;

public class Notebook {
    Integer id;
    String model;
    String processor;
    String ram;
    String hdd;
    String screenDiagonal;
    String operatingSystem;

    public Notebook(Integer i, String m, String p, String r, String h, String s, String o){
        id = i;
        model = m;
        processor = p;
        ram = r;
        hdd = h;
        screenDiagonal = s;
        operatingSystem = o;
    }

    public  boolean comparison(Notebook item, Map params){
        if (item.processor == params.get("processor")){
            return true;
        } else if (item.ram == params.get("ram")) {
            return true;
        } else if (item.hdd == params.get("hdd")) {
            return true;
        } else if (item.screenDiagonal == params.get("screenDiagonal")) {
            return true;
        } else if (item.operatingSystem == params.get("operatingSystem")){
            return true;
        }
        return false;
    }

    @Override
    public String toString(){
        String str;
        str = "Model: " + model + "\tProcessor: " + processor + "\tRAM: " + ram + "Gb" + "\tHDD: " + hdd + "Gb" + "\tScreen diagonal: " + screenDiagonal + '"' + "\tOperating system: " + operatingSystem;
        return str;
    }
}
