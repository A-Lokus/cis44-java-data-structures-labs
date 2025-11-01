public class CompanyTreeDriver
{
    public static void main(String[] args)
    {
        GeneralTreeNode root = new GeneralTreeNode("CEO");
        GeneralTreeNode vpSales = new GeneralTreeNode("VP of Sales");
        GeneralTreeNode vpEngineering= new GeneralTreeNode("VP of Engineering");
        root.addChild(vpSales);
        root.addChild(vpEngineering);

        GeneralTreeNode salesNA =  new GeneralTreeNode("Sales Manager (NA)");
        GeneralTreeNode salesEU = new GeneralTreeNode("Sales Manager (EU)");
        vpSales.addChild(salesNA);
        vpSales.addChild(salesEU);

        GeneralTreeNode devTeamLeader = new GeneralTreeNode("Dev Team Lead");
        GeneralTreeNode qaTeamLeader = new GeneralTreeNode("QA Team Lead");
        vpEngineering.addChild(devTeamLeader);
        vpEngineering.addChild(qaTeamLeader);

        GeneralTreeNode dev1 = new GeneralTreeNode("Developer 1");
        GeneralTreeNode dev2 = new GeneralTreeNode("Developer 2");
        devTeamLeader.addChild(dev1);
        devTeamLeader.addChild(dev2);

        System.out.println("--- Preorder Traversal (Company Hierarchy) ---");
        root.traversePreorder();

        System.out.println("\n--- Postorder Traversal (Staff Roll Call) ---");
        root.traversePostorder();
    }
}