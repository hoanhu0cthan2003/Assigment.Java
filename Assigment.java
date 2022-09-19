
package Assigment;

import java.util.*;

class nhap {
    public static Scanner s1 = new Scanner(System.in);
    public int imei, price, date;
    public String Name, Manufacturer, ram, rom, chip, Ssize, Psize;
    public String getManufacturer(){
        return Manufacturer;
    };

    public void Insert() {
        System.out.print("Enter IMEI: ");
        imei = s1.nextInt();
        s1.nextLine();
        System.out.print("Enter Name: ");
        Name = s1.nextLine();
        System.out.print("Enter Manufacturer: ");
        Manufacturer = s1.nextLine();
        System.out.print("Enter Price: ");
        price = s1.nextInt();
        System.out.print("Enter Date(DDMMYYYY): ");
        date = s1.nextInt();
        s1.nextLine();
        System.out.print("Enter Ram: ");
        ram = s1.nextLine();
        System.out.print("Enter Rom: ");
        rom = s1.nextLine();
        System.out.print("Enter Chip: ");
        chip = s1.nextLine();
        System.out.print("Enter Screen Size: ");
        Ssize = s1.nextLine();
        System.out.print("Enter Phone Size(length x width x thickness): ");
        Psize = s1.nextLine();
    }


    public String toString() {
        return "IMEI: " + imei + " | " +
                "Name: " + Name + " | " +
                "Manufacturer: " + Manufacturer + " | " +
                "Price: " + price + " | " +
                "Date: " + date + " | " +
                "Ram: " + ram + " | " +
                "Rom: " + rom + " | " +
                "Chip: " + chip + " | " +
                "Screen size: " + Ssize + " | " +
                "Phone Size(length x width x thickness): " + Psize + " | ";
    }
}

class output {
    public static void main(String[] args) {
        List<nhap> s = new ArrayList<nhap>();
        Scanner s1 = new Scanner(System.in);
        int c;
        do {
            System.out.println("---------Menu---------");
            System.out.println("[1]. Phone");
            System.out.println("[2]. Tools");
            System.out.println("[3]. Exit");
            System.out.print("Enter Your Choice: ");
            c = s1.nextInt();
            switch (c) {
                case 1:
                    int c1 = 0;
                    do {
                        System.out.println("-----------Menu-----------");
                        System.out.println("[1]. Insert a new phone");
                        System.out.println("[2]. Update a phone");
                        System.out.println("[3]. Delete a phone");
                        System.out.println("[4]. Display all");
                        System.out.println("[5]. Exit");
                        System.out.print("Enter Your Choice: ");
                        c1 = s1.nextInt();
                        switch (c1) {
                            case 1:
                                nhap phone = new nhap();
                                phone.Insert();
                                s.add(phone);
                                break;
                            case 2:
                                boolean found = false;
                                System.out.println("Enter IMEI to Update: ");
                                int imei = s1.nextInt();
                                System.out.println("===============================================");
                                for (nhap phone1 : s) {
                                    if (phone1.imei == imei) {
                                        System.out.print("Enter IMEI: ");
                                        phone1.imei = s1.nextInt();
                                        s1.nextLine();
                                        System.out.print("Enter Name: ");
                                        phone1.Name = s1.nextLine();
                                        System.out.print("Enter Manufacturer: ");
                                        phone1.Manufacturer = s1.nextLine();
                                        System.out.print("Enter Price: ");
                                        phone1.price = s1.nextInt();
                                        s1.nextLine();
                                        System.out.print("Enter Date: ");
                                        phone1.date = s1.nextInt();
                                        System.out.print("Enter Ram: ");
                                        phone1.ram = s1.nextLine();
                                        System.out.print("Enter Rom: ");
                                        phone1.rom = s1.nextLine();
                                        System.out.print("Enter Chip: ");
                                        phone1.chip = s1.nextLine();
                                        System.out.print("Enter Screen Size: ");
                                        phone1.Ssize = s1.nextLine();
                                        System.out.print("Enter Phone Size(length x width x thickness): ");
                                        phone1.Psize = s1.nextLine();
                                    }
                                }
                                if (!found) {
                                    System.out.println("Record Not Found");
                                } else {
                                    System.out.println("Record is Updated Successfully...!");
                                }
                                System.out.println("===============================================");
                                break;
                            case 3:
                                found = false;
                                System.out.println("Enter IMEI to Delete: ");
                                imei = s1.nextInt();
                                System.out.println("===============================================");
                                Iterator<nhap> i = s.iterator();
                                i = s.iterator();
                                while (i.hasNext()) {
                                    nhap n = i.next();
                                    if (n.imei == imei) {
                                        i.remove();
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Record Not Found");
                                } else {
                                    System.out.println("Record is Delete Successfully...!");
                                }
                                System.out.println("===============================================");
                                break;
                            case 4:
                                i = s.iterator();
                                while (i.hasNext()) {
                                    nhap n = i.next();
                                    System.out.println(n);
                                }
                                break;
                        }
                    } while (c1 != 5);
                    break;
                case 2:
                    int c2 = 0;
                    do {
                        System.out.println("-----------Menu-----------");
                        System.out.println("[1]. Filter by manufacturer");
                        System.out.println("[2]. Oder by release date desc");
                        System.out.println("[3]. Filter by price");
                        System.out.println("[4]. Oder by price desc");
                        System.out.println("[5]. Exit");
                        System.out.print("Enter Your Choice: ");
                        c2 = s1.nextInt();
                        switch (c2) {
                            case 1:
                                boolean found = false;
                                s1.nextLine();
                                System.out.print("Enter Manufacturer: ");
                                String Manu = s1.nextLine();
                                Iterator<nhap> i = s.iterator();
                                i = s.iterator();
                                while (i.hasNext()) {
                                    nhap n = i.next();
                                    if (Objects.equals(n.getManufacturer(), Manu)) {
                                        System.out.println(n);
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Record Not Found");
                                }
                                break;
                            case 2:
                                for (int l = 0; l < s.size() -1 ; ++l) {
                                    for (int j = l + 1; j < s.size(); ++j) {
                                        if (s.get(l).date < s.get(j).date) {
                                            nhap g = new nhap();
                                            g.imei = s.get(l).imei;
                                            g.Name = s.get(l).Name;
                                            g.Manufacturer = s.get(l).Manufacturer;
                                            g.price = s.get(l).price;
                                            g.date = s.get(l).date;
                                            g.ram = s.get(l).ram;
                                            g.rom = s.get(l).rom;
                                            g.chip = s.get(l).chip;
                                            g.Ssize = s.get(l).Ssize;
                                            g.Psize = s.get(l).Psize;

                                            s.get(l).imei = s.get(j).imei;
                                            s.get(l).Name = s.get(j).Name;
                                            s.get(l).Manufacturer = s.get(j).Manufacturer;
                                            s.get(l).price = s.get(j).price;
                                            s.get(l).date = s.get(j).date;
                                            s.get(l).ram = s.get(j).ram;
                                            s.get(l).rom = s.get(j).rom;
                                            s.get(l).chip = s.get(j).chip;
                                            s.get(l).Ssize = s.get(j).Ssize;
                                            s.get(l).Psize = s.get(j).Psize;

                                            s.get(j).imei = g.imei;
                                            s.get(j).Name = g.Name;
                                            s.get(j).Manufacturer = g.Manufacturer;
                                            s.get(j).price = g.price;
                                            s.get(j).date = g.date;
                                            s.get(j).ram = g.ram;
                                            s.get(j).rom = g.rom;
                                            s.get(j).chip = g.chip;
                                            s.get(j).Ssize = g.Ssize;
                                            s.get(j).Psize = g.Psize;
                                        }
                                    }
                                }
                                break;
                            case 3:
                                System.out.print("Enter Price: ");
                                int Price = s1.nextInt();
                                i = s.iterator();
                                while (i.hasNext()) {
                                    nhap n = i.next();
                                    if (n.price == Price) {
                                        System.out.println(n);
                                    }
                                }
                                break;
                            case 4:
                                for (int l = 0; l < s.size() -1 ; ++l) {
                                    for (int j = l + 1; j < s.size(); ++j) {
                                        if (s.get(l).price < s.get(j).price) {
                                            nhap g = new nhap();
                                            g.imei = s.get(l).imei;
                                            g.Name = s.get(l).Name;
                                            g.Manufacturer = s.get(l).Manufacturer;
                                            g.price = s.get(l).price;
                                            g.date = s.get(l).date;
                                            g.ram = s.get(l).ram;
                                            g.rom = s.get(l).rom;
                                            g.chip = s.get(l).chip;
                                            g.Ssize = s.get(l).Ssize;
                                            g.Psize = s.get(l).Psize;

                                            s.get(l).imei = s.get(j).imei;
                                            s.get(l).Name = s.get(j).Name;
                                            s.get(l).Manufacturer = s.get(j).Manufacturer;
                                            s.get(l).price = s.get(j).price;
                                            s.get(l).date = s.get(j).date;
                                            s.get(l).ram = s.get(j).ram;
                                            s.get(l).rom = s.get(j).rom;
                                            s.get(l).chip = s.get(j).chip;
                                            s.get(l).Ssize = s.get(j).Ssize;
                                            s.get(l).Psize = s.get(j).Psize;

                                            s.get(j).imei = g.imei;
                                            s.get(j).Name = g.Name;
                                            s.get(j).Manufacturer = g.Manufacturer;
                                            s.get(j).price = g.price;
                                            s.get(j).date = g.date;
                                            s.get(j).ram = g.ram;
                                            s.get(j).rom = g.rom;
                                            s.get(j).chip = g.chip;
                                            s.get(j).Ssize = g.Ssize;
                                            s.get(j).Psize = g.Psize;
                                        }
                                    }
                                }
                                break;
                        }
                    } while (c2 != 5);
                    break;
            }
        } while (c != 3);
        System.out.println("Thank For Using!");
    }
}
