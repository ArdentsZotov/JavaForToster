package DZ7;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class JsonOrganizationsShowImpl implements JsonOrganizationsShow {
    private String jsonString;
    private List<Organization> orgList;

    public JsonOrganizationsShowImpl() {
        Scanner scan = new Scanner(System.in);
        String filePath = scan.nextLine();
        try {
            jsonString = parsJsonFile(filePath);
            orgList = Arrays.asList(setListOrganization());
        } catch (NullPointerException exp) {
            jsonString = "";
            orgList = new ArrayList<>();
        }
    }

    public JsonOrganizationsShowImpl(String filePath) {
        try {
            jsonString = parsJsonFile(filePath);
            orgList = Arrays.asList(setListOrganization());
        } catch (NullPointerException exp) {
            jsonString = "";
            orgList = new ArrayList<>();
        }
    }

    // считывание файла .json по указанному пути
    private String parsJsonFile(String filePath) {
        File someFile = new File(filePath);
        StringBuilder st = new StringBuilder();
        try {
            Scanner scan1 = new Scanner(someFile);
            while (scan1.hasNext()) {
                st.append(scan1.nextLine() + "\n");
            }
            return st.toString();
        } catch (FileNotFoundException exp) {
            return null;
        }
    }

    // формирование Organization[] средствами json
    private Organization[] setListOrganization() {
        Organization[] org;
        try {
            Gson gson = new Gson();
            org = gson.fromJson(jsonString, Organization[].class);
            return org;
        } catch (NullPointerException exp) {
            throw exp;
        }
    }

    // демонстраций всех организаций
    public void showAllOrganization() {
        orgList.stream().forEach(x -> System.out.println(x.toString()));
    }


    public void showOverduePaper() {
        int count = 0;
        for (Organization a : orgList) {
            Arrays.asList(a.securities).stream()
                    .filter(x ->
                            {
                                Calendar cl = new GregorianCalendar(Integer.parseInt(x.date_to.substring(0, 4)),
                                        Integer.parseInt(x.date_to.substring(5, 7)) - 1,
                                        Integer.parseInt(x.date_to.substring(8, 10)));
                                if (new Date().after(new Date(cl.getTimeInMillis()))) return true;
                                else return false;
                            }
                    )
                    .forEach(x -> System.out.println(x.id + "; " + x.date_to + "; " + a.name_full));

        }
        System.out.println("Всего просроченных бумаг:" + countOverduePaper());
    }

    private int countOverduePaper() {
        int count = 0;
        for (Organization a : orgList) {
            count += Arrays.asList(a.securities).stream()
                    .filter(x -> {
                                Calendar cl = new GregorianCalendar(Integer.parseInt(x.date_to.substring(0, 4)),
                                        Integer.parseInt(x.date_to.substring(5, 7)) - 1,
                                        Integer.parseInt(x.date_to.substring(8, 10)));
                                if (new Date().after(new Date(cl.getTimeInMillis()))) return true;
                                else return false;
                            }
                    )
                    .count();
        }
        return count;
    }

    public void showOrganizationAfterDate() {
        Scanner scan = new Scanner(System.in);
        String date = scan.nextLine();
        // упрощенная проверка, не проверяет на вискоксные года, на дней в месяце > 31 и тд
        // да и сам формат задан нестрого, поэтому проверка услованая
        if (date.matches("^([0-3][0-9][\\.\\/][01][0-9][\\.\\/]([12][0-9])?[0-9]{2})$"))
            showOrganizationAfterDate(date);
        else System.out.println("Non format;");
    }

    public void showOrganizationAfterDate(String date) {
        int DD = Integer.parseInt(date.substring(0, 2));
        int MM = Integer.parseInt(date.substring(3, 5));
        int YY = Integer.parseInt(date.substring(6));

        // если год записан неявно, в виде YY, то при YY<70 предполагаются года до 2069
        // если YY>70, то года берутся от 1970
        if (YY < 100) {
            if (YY >= 70) YY += 1900;
            else YY += 2000;
        }
        Calendar cdp = new GregorianCalendar(YY, MM - 1, DD);

        orgList.stream()
                .filter(x ->
                {
                    Calendar cdz = new GregorianCalendar(
                            Integer.parseInt(x.egrul_date.substring(0, 4)),
                            Integer.parseInt(x.egrul_date.substring(5, 7)) - 1,
                            Integer.parseInt(x.egrul_date.substring(8, 10)));
                    if (cdp.after(cdz)) return false;
                    else return true;
                })
                .forEach(x -> System.out.println(x.name_full + ", " + x.egrul_date));
    }

    public void showSecuritiesValut() {
        Scanner scan = new Scanner(System.in);
        String data = scan.nextLine();
        if (data.matches("[A-Z]{3}"))
            showSecuritiesValut(data);
        else System.out.println("Non format;");
    }

    public void showSecuritiesValut(String data) {
        for (Organization a : orgList) {
            Arrays.asList(a.securities)
                    .stream()
                    .filter(x -> x.currency.code.equalsIgnoreCase(data))
                    .forEach(y -> System.out.println(y.id + ", " + y.code));
        }
    }
}
