package DZ7;

public interface JsonOrganizationsShow  {

    /**
     * На входе имеется файл формата .json, содержащий информацию о каком- то кол-ве организаций,
     * в т. ч. названия, адреса и тд.
     * На основе файла необходимо сформировать коллекцию, где каждый объект предоставляет одну организацию.
     *
     * Для реализации данного класса используется библиотека json-2.8.2, значительно облегчающая
     * парсинг .json. В документе приожена.
     *
     * Вложенный класс Organization представялет структуру файла test.json. Объект единичной компании создается
     * на основе этого класса. Он имеет открытые поля, не имеет методов.
     *
     * Реализация имплементирующего класса JsonOrganizationsShowImpl
     *
     * предоставляет два конструктора:
     * JsonOrganizationsShowImpl() - путь к файлу указывается вручную;
     * JsonOrganizationsShowImpl(String filePath) - строка-путь к файлу;
     */

    /**
     * Dывести все имеющиеся компании в виде Краткое название - Дата основания дд/мм/гг;
     */
    void showAllOrganization();

    /**
     * Вывести все ценные бумаги (код, дату истечениея и полное название организации владельца),
     * которые просрочены на текущий день, а также посчитать суммарное число таких бумаг;
     */
    void showOverduePaper();

    /**
     * На запрос пользователя ввида дд.мм.гггг, дд.мм.гг, дд/мм/гггг, дд/мм/гг вывести название и дату организаций,
     * основанных после этой даты (включая саму дату).
     * первый метод предоставляет возможность вести адрес к файлу, второй работает от строки;
     *
     * Форматы дд.мм.гг и дд/мм/гг строго не обозначе по году, логика определения года выбрана условна
     * и предоставлена в методе
     */
    void showOrganizationAfterDate();
    void showOrganizationAfterDate(String date);

    /**
     * На запрос пользователя в виде трехбуквенного кода валюты вывести id и код ценной бумаги,
     * использующей заданную валюту. Также как и в предыдущем методе, предлагается два метода с разной сигнатурой
     */
    void showSecuritiesValut();
    void showSecuritiesValut(String data);





    public class Organization {

        int id;
        String code;
        String name_full;
        String name_short;
        String inn;
        CompanyType company_type;
        String ogrn;
        String egrul_date;
        Country country;
        String fio_head;
        String address;
        String phone;
        String e_mail;
        String www;
        boolean isResident;
        securitie[] securities;

        private class CompanyType {
            int id;
            String name_short;
            String name_full;
        }

        public class Country {
            int id;
            String code;
            String name;
        }

        public class securitie{
            int id;
            String code;
            String name_full;
            String cfi;
            String date_to;
            String state_reg_date;
            State state;
            Currency currency;

            public class State{
                int id;
                String name;
            }

            public class Currency{
                int id;
                String code;
                String name_short;
                String name_full;
            }
        }

        @Override
        public String toString()
        {
            return this.name_short+" - Дата основания "+
                    egrul_date.substring(egrul_date.length()-2)+"/"+
                    egrul_date.substring(5,7)+"/"+
                    egrul_date.substring(2,4);
        }
    }
}
