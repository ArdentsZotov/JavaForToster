package DZ7;

public class JSPActions {
    public static void main(String[] args)  {

        JsonOrganizationsShowImpl jspmc = new JsonOrganizationsShowImpl("files/test.json");
        jspmc.showAllOrganization();
        System.out.println();
        jspmc.showOverduePaper();
        System.out.println();
        jspmc.showOrganizationAfterDate("27/12/1994");
        System.out.println();
        jspmc.showSecuritiesValut("rub");

    }
}
