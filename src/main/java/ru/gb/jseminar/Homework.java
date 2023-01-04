package ru.gb.jseminar;

import ru.gb.jseminar.data.Notebook;

import java.util.*;

public class Homework {

    // 1) Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы. Реализовать в java.
    // 2) Создать коллекцию ноутбуков.
    // 3) Написать мапу, которая будет содержать критерий (или критерии) фильтрации и выведет
    //      ноутбуки, отвечающие фильтру.
    //      Пример: ОЗУ - Значение, Объем ЖД - Значение, Операционная система - Значение, Цвет - Значение
    // 4) Отфильтровать ноутбуки их первоначального множества и вывести проходящие по условиям.
    public static void main(String[] args) {
        Homework hw = new Homework();
        List<Notebook> listNotebook;
        listNotebook = hw.initListNotebooks();

        hw.filter(listNotebook);
    }

    public List<Notebook> initListNotebooks(){
        List<Notebook> list = new ArrayList();
        list.add(new Notebook(1, "Lenovo ThinkPad P73", "Intel Core i7", "16", "1000", "17.3", "Windows 10"));
        list.add(new Notebook(2, "Dell Alienware M17-8123", "Intel Core i7", "16", "1000", "17.3", "Windows 10"));
        list.add(new Notebook(3, "ASUS GL731GV", "Intel Core i7", "16", "1000", "17.3", "Windows 10"));
        list.add(new Notebook(4, "ASUS VivoBook X513EA-BQ1608T", "Intel Core i5", "16", "1000", "15.6", "noOS"));
        list.add(new Notebook(5, "Acer TravelMate P2510-G2-MG-31LF", "Intel Core i3", "4", "500", "15.6", "Windows 10"));
        list.add(new Notebook(6, "Lenovo V130-15IKB", "Intel Core i3", "8", "1000", "15.6", "Windows 10"));
        list.add(new Notebook(7, "Lenovo Legion Y530-15ICH", "Intel Core i5", "8", "1000", "15.6", "Windows 10"));
        list.add(new Notebook(8, "Dell Inspiron 3511", "Intel Core i5", "8", "1000", "15.6", "Windows 11"));
        return list;
    }

    public void filter(List<Notebook> notebooks){
        Map<String, String> params = new HashMap<>();
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - Processor; 2 - RAM; 3 - HDD; 4 - Screen diagonal; 5 - Operating system");
        System.out.print("Введите цифру --> ");
        String number = new Scanner(System.in).next();
        switch (number){
            case "1":
                List<String> processorList = List.of("Intel Core i3", "Intel Core i5", "Intel Core i7");
                System.out.println("Выберите процессор: 0 - Intel Core i3; 1 - Intel Core i5; 2 - Intel Core i7");
                System.out.print("Введите цифру --> ");
                int proc = new Scanner(System.in).nextInt();
                params.put("processor", processorList.get(proc));
                break;
            case "2":
                List<String> ramList = List.of("4", "8", "16");
                System.out.println("Выберите размер ОЗУ: 0 - 4 Gb; 1 - 8 Gb; 2 - 16 Gb");
                System.out.print("Введите цифру --> ");
                int ram = new Scanner(System.in).nextInt();
                params.put("ram", ramList.get(ram));
                break;
            case "3":
                List<String> hddList = List.of("500", "1000");
                System.out.println("Выберите объем ЖД: 0 - 500 Gb; 1 - 1000 Gb");
                System.out.print("Введите цифру --> ");
                int hdd = new Scanner(System.in).nextInt();
                params.put("hdd", hddList.get(hdd));
                break;
            case "4":
                List<String> screenDiagonalList = List.of("15.6", "17.3");
                System.out.println("Выберите размер экрана: 0 - 15,6"+'"'+"; 1 - 17,3"+'"');
                System.out.print("Введите цифру --> ");
                int scr = new Scanner(System.in).nextInt();
                params.put("screenDiagonal", screenDiagonalList.get(scr));
                break;
            case "5":
                List<String> operatingSystemList = List.of("noOS", "Windows 10", "Windows 11");
                System.out.println("Выберите операционную систему: 0 - noOS; 1 - Windows 10; 2 - Windows 11");
                System.out.print("Введите цифру --> ");
                int os = new Scanner(System.in).nextInt();
                params.put("operatingSystem", operatingSystemList.get(os));
                break;
        }

        for (Notebook item : notebooks) {
            if (item.comparison(item,  params)){
                System.out.println(item.toString());
            }
        }
    }
}
