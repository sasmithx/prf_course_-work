import java.util.*;
class Main {

    private static Scanner input = new Scanner(System.in);
    static String[][] cred = new String [1][2];			//Credential Manage Array
	static String[][] supplier = new String[1][2];		//Supplier Manage Array	
	static String[] ic = new String[1];					//Item Category Array
	static String[][] ai = new String[1][6];			//Add Item Array
	static boolean loggedIn  = false;					
	static boolean correctps = false;
	static String password = "";	
	static String userName = "";
    static String newpass  = "";	
	static String id = "";
	
  
   private final static void clearConsole() {
	final String os = System.getProperty("os.name");
		try {
				if (os.equals("Linux")) {
					System.out.print("\033\143");
			} else if (os.equals("Windows")) {
					new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
					System.out.print("\033[H\033[2J");
					System.out.flush();
			}
			} catch (final Exception e) {
				//handle the exception
				System.err.println(e.getMessage());
			}
	}
  
  public static void ranked(){
			    System.out.println("+-------------------------------------------------------------------+");
				System.out.println("|                    RANKED UNIT PRICE				    |");
				System.out.println("+-------------------------------------------------------------------+");
  
		
	
			for (int i = 0; i < ai.length - 1; i++) {
				for (int j = 0; j < ai.length - 1; j++) {
					if(Double.parseDouble(ai[j][3]) >Double.parseDouble(ai[j+1][3])) {
						String[] temp = ai[j];
						ai[j] = ai[j+1];
						ai[j+1] = temp;
					}
				}
			}
	
			System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
			System.out.println("|    SID      |    CODE     |    DESC     |   PRICE     |    QTY      |    CAT      |");
			System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
			for (int l = 0; l < ai.length; l++) {
				
				for (int j = 0; j < ai[l].length; j++) {
					System.out.printf("%-5s%-9s","|",ai[l][j]);
				}
				System.out.println("|");
			}
			System.out.println("+-------------+-------------+-------------+-------------+-------------+-------------+");
		
	
			System.out.println("Do you want to go stock manage page? (Y/N)");
			char x = input.next().charAt(0);
			
			if(x == 'Y' || x == 'y'){
				
			clearConsole();
			stockmanage();
			
			}
			
			else if(x == 'N' || x == 'n'){
			
			clearConsole();
			homepage(input);
			
			}
			
	
	}
	
		public static void viewitems(){
				System.out.println("+-------------------------------------------------------------------+");
				System.out.printf("%-29s%-39s%s","|","VIEW ITEMS","|\n");
				System.out.println("+-------------------------------------------------------------------+");
				
	
			for (int i = 0; i <ic.length; i++){
		
				System.out.println(ic[i]);
			
				System.out.println("+------------+------------+------------+------------+------------+");
				System.out.println("|   SID      |   CODE     |   DESC     |  PRICE     |  QTY       |");
				System.out.println("+------------+------------+------------+------------+------------+");
				for (int l = 0; l < ai.length; l++) {
					if(ic[i].equals(ai[l][5])){
						for (int j = 0; j < ai[l].length; j++) {
							if(j!=5)System.out.printf("%-5s%-8s","|",ai[l][j]);
						}
							System.out.println("|");
					}
				}
				System.out.println("+------------+------------+------------+------------+------------+");
			}
			
			System.out.println("Do you want to go stock manage page? (Y/N)");
			char x = input.next().charAt(0);
			
				if(x == 'Y' || x == 'y'){
				
			clearConsole();
			stockmanage();
			
			}
			
			else if(x == 'N' || x == 'n'){
			
			clearConsole();
			homepage(input);
			
			}
		
	}
   
   public static void supplierwise(){
				System.out.println("+-------------------------------------------------------------------+");
				System.out.println("|                     SEARCH ITEMS SUPPLIER  WISE                   |");
				System.out.println("+-------------------------------------------------------------------+");
	   
	L1:while(true){
				System.out.println("Enter Supplier Id:");
				String x = input.next();
				boolean found = false;
				
				int y=0;
				
				for (int i = 0; i < supplier.length; i++){
					if(x.equals(supplier[i][0])){
						y = i;
						found = true;
						break;
					}
				}
			
				if(found==false){
				System.out.println("Can't find supplier ID,please try again!");
				
				continue L1;
				}
			
				System.out.println("Supplier Name:"+supplier[y][1]);
			
			
				System.out.println("\nSuppliers list:");
				System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
				System.out.println("|   ITEM CODE       |   DESCRIPTTION    |   UNIT PRICE      |   QTY ON HAND     |    CATEGORY	    |");
				System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
				for (int l = 0; l < ai.length; l++) {
				
					for (int j = 0; j < ai[l].length; j++) {
					if(j!=0)System.out.printf("%-8s%-12s","|",ai[l][j]);
					}
					System.out.println("|");
				}
				System.out.println("+-------------------+-------------------+-------------------+-------------------+-------------------+");
			
			
			
			System.out.print("search successfully! Do you want to another search (Y/N)");
			char xr = input.next().charAt(0);
			
			if(xr == 'N' || xr == 'n'){
				clearConsole();
				stockmanage();
				break;
			}
			
			else if (xr == 'Y' || xr == 'y'){
			continue L1;
			}
			
		}
		}
	
	public static String[][] growitem1() {
		String[][] temp = new String[ai.length + 1][6];
		for (int i = 0; i < ai.length; i++){
			for (int j = 0; j < ai[i].length; j++){
				temp[i][j] = ai[i][j];
			}
		}
		
		return temp;
	}
	 
	
	public static void additem1(){
	   
				System.out.println("+-------------------------------------------------------------------+");
				System.out.println("|                              ADD ITEM                             |");
				System.out.println("+-------------------------------------------------------------------+");
	    
	    
	    
	    if (null == ic[0]){
			System.out.println("\nOOPS! It seems that you don't have any item categories in the system.");
			System.out.print("Do you want to add a new item category?(Y/N) ");
			char nc = input.next().charAt(0);
			if (nc == 'Y' || nc == 'y') {
				clearConsole();
				additem();
			}
			if (nc == 'N' || nc == 'n') {
				clearConsole();
				System.exit(0);
			}
			else {
				clearConsole();
				System.exit(0);
			}
		}
		if (null == supplier[0][0]){
			System.out.println("\nOOPS! It seems that you don't have any suppliers in the system.");
			System.out.print("Do you want to add a new supplier?(Y/N) ");
			char ns = input.next().charAt(0);
			if (ns == 'Y' || ns == 'y') {
				clearConsole();
				addsupplier();         
			}
			if (ns == 'N' || ns == 'n') {
				clearConsole();
				stockmanage();
			}
			else {
				clearConsole();
				System.exit(0);
			}
		}
		int i = 0;
		
   L239: while(true) {
			System.out.print("\nItem Code  : ");
			String itemInput = input.next();
			for (int a = 0; a < ai.length; a++) {
				if (itemInput.equals(ai[a][1])) {
					System.out.println("already exists. try another Item Code!");
					
					continue L239;
				}
			}
			
			ai[i][1] = itemInput;
				
			System.out.println("\nSuppliers list:");
			System.out.println("+-------------+-------------------+-------------------+");
			System.out.println("|      #      |    SUPPLIER ID    |   SUPPLIER NAME   |");
			System.out.println("+-------------+-------------------+-------------------+");
			for (int l = 0; l < supplier.length; l++) {
				System.out.printf("%-7s%-7d","|",(l+1));
				for (int j = 0; j < supplier[l].length; j++) {
					System.out.printf("%-8s%-12s","|",supplier[l][j]);
				}
				System.out.println("|");
			}
			System.out.println("+-------------+-------------------+-------------------+");
	L264:	while (true) {
				System.out.print("\nEnter the supplier number > ");
				int n = input.nextInt();
				boolean num = true;
				for (int y = 0; y < supplier.length; y++) {
					if ((n - 1) == y) {
						ai[i][0] = supplier[y][0];
						num = false;
						break L264;
					}
				}
				if (num) {
					System.out.println("Invalid number. Try again!");
					continue L264;
				}
			}
			System.out.println("\nItem Categories:");
			System.out.println("+-----------+--------------------------+");
			System.out.println("|     #     |      CATEGORY NAME       |");
			System.out.println("+-----------+--------------------------+");
			for (int q = 0; q < ic.length; q++){
				System.out.printf("%-6s%-6d%-9s%-18s%s","|",(q+1),"|",ic[q],"|");
				System.out.println();
			}
			System.out.println("+-----------+--------------------------+");
	L289:	while (true) {
				System.out.print("\nEnter the category number > ");
				int n1 = input.nextInt();
				boolean num1 = true;
				for (int c = 0; c < ic.length; c++) {
					if ((n1 -1) == c) {
						ai[i][5] = ic[c];
						num1 = false;
						break L289;
					}
				}
				if (num1) {
					System.out.println("Invalid number. Try again!");
					continue L289;
				}
			}
			System.out.print("\nDescription  : ");
			ai[i][2] = input.next();
			System.out.print("Unit price   : ");
			ai[i][3] = input.next();
			System.out.print("Qty on hand  : ");
			ai[i][4] = input.next();
			System.out.print("added successfully! Do you want to add another Item(Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				ai = growitem1();
				i++;
				clearConsole();
				System.out.println("+-------------------------------------------------------------------+");
				System.out.println("|                              ADD ITEM                             |");
				System.out.println("+-------------------------------------------------------------------+");
				continue L239;    
			}
			if (add == 'N' || add == 'n') {
				clearConsole();
				stockmanage();
			}
			else {
				clearConsole();
				System.exit(0);
			}
		}
		
		}
		
		
		
	public static String[] growitem() {
		String[] temp = new String[ic.length + 1];
		for (int i = 0; i < ic.length; i++){
			for (int j = 0; j < ic.length; j++){
				temp[i] = ic[i];
			}
		}
		
		return temp;
	}
	  	
	public static void updateitem() { 
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     UPDATE ITEM CATEGORY                          |");
        System.out.println("+-------------------------------------------------------------------+");

    L1: while (true) {
			System.out.print("\n Category Name: ");
			String up = input.next();
			boolean found = false;

        for (int i = 0; i < ic.length; i++) {
       
			if (up.equals(ic[i])) {
				System.out.print("Enter the new Item Category: ");
				String catname = input.next();
				ic[i] = catname;
				found = true;
				break;
			}
        
        
		}

        if (!found) {
        System.out.println("Can't find category, please try again!");
        
        	continue L1;
        }

			System.out.print("Updated Successfully! Do you want to update another item category? (Y/N)");
			char upd = input.next().charAt(0);

			if (upd == 'N' || upd == 'n') {
				clearConsole();
				supmanage();
				break;
			} 
			else if (upd == 'Y' || upd == 'y') {
				ic = growitem();
				continue L1;
        
			}
        }
			deletesupplier();
        }

   
   
   public static String[] removecat(int xi) {
		String[] temp = new String[ic.length - 1];
	L1:	for (int i = 0,x = 0; i < ic.length; i++){
			
				if(i==xi){
					continue L1;
				}
				temp[x] = ic[i];
					
			x++;
		}
		return temp;
	}
   
   
   
	public static void deleteitem(){ 
	   System.out.println("+-------------------------------------------------------------------+");
       System.out.println("|                     	DELETE ITEM CATEGORY                       |");
       System.out.println("+-------------------------------------------------------------------+");
   
	   L1:	while(true){
			System.out.print("\nItem Category: ");
			String icat = input.next();
			boolean found = false;
		
			int xi=0;
			
			for (int i = 0; i < ic.length; i++) {
				if (icat.equals(ic[i])) {
				xi=i;
				found=true;
				break;
        }
			
	}		
				
		if (found==false) {
			System.out.println("Can't find Item Category, please try again!");
        
        	continue L1;
        }

		ic=removecat(xi);
		
	
		System.out.print("delete Successfully! Do you want to delete another Item Category? (Y/N)");
		char item = input.next().charAt(0);
			
        if (item == 'N' || item == 'n') {
			clearConsole();
			manageitem();
			break;
        } 
        else if (item == 'Y' || item == 'y') {
		continue L1;
        
        }
		
		}
	
	}
   
   public static String[] growcat(){
	   String[] temp = new String[ic.length+1];
	   for (int i = 0; i <ic.length; i++){
		   temp[i] = ic[i];
		}
		return temp;
	}
	   
	
	public static void additem(){
		System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     ADD ITEM CATEGORY                             |");
        System.out.println("+-------------------------------------------------------------------+");
   
		if(ic.length == 0) ic = growcat();
 
 L1:	while(true){	
		System.out.println("Enter the new item Category");
		String x = input.next();
		for (int i = 0; i <ic.length; i++){
			if(x.equals(ic[i])){
				System.out.println("already exists.try another category!");
				continue L1;
			}	
		}
		ic[ic.length-1] = x;
		System.out.print("added Successfully! Do you want  to add another category(Y/N)?");
		char cat = input.next().charAt(0);
		if(cat == 'Y' || cat == 'y'){
			ic=growcat();
			clearConsole();
			additem();
		}
		if(cat == 'N' || cat == 'n'){
			clearConsole();
			stockmanage();
		}
		else{
			clearConsole();
			System.exit(0);
		}
	}
}		
   
   
   public static void manageitem(){
		System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     MANAGE ITEM CATEGORY                          |");
        System.out.println("+-------------------------------------------------------------------+");
	   
		System.out.print("[1] Add New Item Category");
		System.out.println("\t\t\t[2] Delete Item Category");
		System.out.print("[3] Update Item Category");
		System.out.println("\t\t\t[4] Stock Management");
	   
	   System.out.println("Enter an option to continue >");
	   int x = input.nextInt();
	   
	   if(x == 1){
		clearConsole();
		additem();
	   }
	   
	   else if(x == 2){
		 clearConsole();
		 deleteitem();
	   }
	   
	   else if(x == 3){
		 clearConsole();	
		 updateitem();
	  }
		
	   else if(x == 4){
		 clearConsole();
		 stockmanage();
		}
	}
	
   
   
   public static void stockmanage(){
		System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     STOCK MANAGEMENT                              |");
        System.out.println("+-------------------------------------------------------------------+");
	   
		System.out.print("[1] Manage Item Categories");
		System.out.println("\t\t\t[2] Add Item");
		System.out.print("[3] Get Items Supplier Wise");
		System.out.println("\t\t\t[4] View Items");
		System.out.print("[5] Rank Items Per Unit Price");
		System.out.println("\t\t\t[6] Home Page");
		
		
		System.out.println("Enter an option to continue >");
		int x = input.nextInt();
		
		if(x == 1){
			clearConsole();
			manageitem();
		}
		else if(x == 2){
			clearConsole();
			additem1();
		}
		else if(x == 3){
			clearConsole();
			supplierwise();
		}	
		
		else if(x == 4){
			clearConsole();
			viewitems();
		}
		
		else if(x == 5){
			clearConsole();
			ranked();
			
		}
		
		else if(x == 6){
			clearConsole();
			homepage(input);
		}
	}
	
   
   
	public static void searchsupplier(){
	   
	    System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     SEARCH SUPPLIERS                              |");
        System.out.println("+-------------------------------------------------------------------+");
   
L1:	while(true){
			System.out.print("\nSupplier ID: ");
			String supid = input.next();
			boolean found = false;
		
			int y = 0;
			
			for (int i = 0; i < supplier.length; i++){
				if (supid.equals(supplier[i][0])){
					y=i;
					found=true;
					break;
				}
			}
						
		if (found==false) {
			System.out.println("Can't find supplier ID, please try again!");
        
        	continue L1;
        }
		System.out.println("Supplier Name:"+supplier[y][1]);	
		
		System.out.print("added Successfully! Do you want to add another find? (Y/N)");
		char src = input.next().charAt(0);
			
        if (src == 'N' || src == 'n') {
			clearConsole();
			supmanage();
			break;
        } 
        else if (src == 'Y' || src == 'y') {
		continue L1;
        
        }
		
	}
	}
   
   
	public static void viewsupplier(){
	   
		System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     	VIEW SUPPLIERS                              |");
        System.out.println("+-------------------------------------------------------------------+");
   
		System.out.println("+-------------------+-------------------+");
		System.out.println("|    SUPPLIER ID    |  SUPPLIER NAME    |");
		System.out.println("+-------------------+-------------------+");
		for (int i = 0; i < supplier.length; i++) {
			
			for (int j = 0; j < supplier[i].length; j++) {
				System.out.printf("%-8s%-12s","|",supplier[i][j]);
			}
			System.out.println("|");
 		}
 		System.out.println("+-------------------+-------------------+");
 		System.out.print("Do you want to go supplier manage page(Y/N)? ");
 		char x = input.next().charAt(0);
		if (x == 'Y' || x == 'y') {
			clearConsole();
			supmanage();
		}
		if (x == 'N' || x== 'n') {
			System.exit(0);
		}
	}
   
	public static String[][] removesupplier(int xi) {
		String[][] temp = new String[supplier.length - 1][2];
	L1:	for (int i = 0,x = 0; i < supplier.length; i++){
			for (int j = 0; j < supplier[i].length; j++){
				if(i==xi){
					continue L1;
				}
				temp[x][j] = supplier[i][j];
			}		
			x++;
		}
		return temp;
	}
		
	
	public static void deletesupplier(){
		
		System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     DELETE SUPPLIER                               |");
        System.out.println("+-------------------------------------------------------------------+");
	
		
	L1:	while(true){
			System.out.print("\nSupplier ID: ");
			String supid = input.next();
			boolean found = false;
		
			int xi=0;
			
			for (int i = 0; i < supplier.length; i++) {
				if (supid.equals(supplier[i][0])) {
				xi=i;
				found=true;
				break;
        }
			
	}		
				
		if (found==false) {
			System.out.println("Can't find supplier ID, please try again!");
        
        	continue L1;
        }
		System.out.println("Supplier id:"+supplier[xi][0]);
		supplier=removesupplier(xi);
		
	
		System.out.print("delete Successfully! Do you want to delete another supplier? (Y/N)");
			char upd = input.next().charAt(0);
			
        if (upd == 'N' || upd == 'n') {
			clearConsole();
			supmanage();
			break;
        } 
        else if (upd == 'Y' || upd == 'y') {
		continue L1;
        
        }
		
	}
		
	
}
		public static void updatesupplier() {
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                     UPDATE SUPPLIER                               |");
        System.out.println("+-------------------------------------------------------------------+");

    L1:    while (true) {
        System.out.print("\nSupplier ID: ");
        String up = input.next();
        boolean found = false;

        for (int i = 0; i < supplier.length; i++) {
			for (int j = 0; j < supplier[i].length; j++) {
				if (up.equals(supplier[i][j])) {
				System.out.print("Enter the new supplier Name: ");
				String supname = input.next();
				supplier[i][1] = supname;
				found = true;
				break;
				}
			}
        
        }

        if (!found) {
        System.out.println("Can't find supplier ID, please try again!");
        
        	continue L1;
        }

        System.out.print("Updated Successfully! Do you want to update another supplier? (Y/N)");
        char upd = input.next().charAt(0);

        if (upd == 'N' || upd == 'n') {
			clearConsole();
			supmanage();
			break;
        } 
        else if (upd == 'Y' || upd == 'y') {
			supplier = growsupplier();
			continue L1;
        
        }
        }
			deletesupplier();
        }
   public static String[][] growsupplier() {
		String[][] temp = new String[supplier.length + 1][2];
		for (int i = 0; i < supplier.length; i++){
			for (int j = 0; j < supplier[i].length; j++){
				temp[i][j] = supplier[i][j];
			}
		}
		
		return temp;
	}
   
   
   public static void addsupplier(){
	   
	   
	   System.out.println("+-------------------------------------------------------------------+");
       System.out.println("|                     	ADD SUPPLIER                                |");
       System.out.println("+-------------------------------------------------------------------+");
	
		if(supplier.length == 0) supplier = growsupplier();
		
   
		
	L1: while (true) {
			System.out.print("\nSupplier ID    : ");
			String id = input.next();
			
			for (int i = 0,j = 0; i < supplier.length; i++) {
				if (id.equals(supplier[i][j])) {
					System.out.println("already exists. try another supplier id!");
					continue L1;
				}
			}
			supplier[supplier.length-1][0] = id;
			System.out.print("Supplier Name  : ");
			supplier[supplier.length-1][1] = input.next();
			System.out.print("added Successfully! Do you want to add another supplier(Y/N)? ");
			char add = input.next().charAt(0);
			if (add == 'Y' || add == 'y') {
				supplier = growsupplier();
				continue L1;
			}
			
			else {
				clearConsole();
				supmanage();
			}
		}
	}
  
   
    public static void supmanage(){
	   System.out.println("+-------------------------------------------------------------------+");
       System.out.println("|                     	SUPPLIER MANAGE                             |");
       System.out.println("+-------------------------------------------------------------------+");
   
   
		System.out.print("[1] Add Supplier");
        System.out.println("			[2] Update Supplier");
        System.out.print("[3] Delete Supplier");
        System.out.println("			[4] View Supplier");
        System.out.print("[5] Search Supplier");
        System.out.println("			[6] Home Page");
   
		System.out.println("Enter an option to continue");
		int sup = input.nextInt();
		
		if(sup == 1){
			clearConsole();
			addsupplier();
		}
		else if(sup == 2){
			clearConsole();
			updatesupplier();
		}
		else if(sup == 3){
			clearConsole();
			deletesupplier();
			
		}
		else if(sup == 4){
			clearConsole();
			viewsupplier();
		}
		else if(sup == 5){
			clearConsole();
			searchsupplier();
		}
		else if(sup == 6){
			clearConsole();
			homepage(input);
		}
   
   
   }
   
   
   
   public static void change(){

       System.out.println("+-------------------------------------------------------------------+");
       System.out.println("|                     CREDENTIAL MANAGE                             |");
       System.out.println("+-------------------------------------------------------------------+");

        
        
        while (!loggedIn) {
            System.out.print("Please enter the user name to verify it's you: ");
             userName = input.next();

              if (userName.equals(cred[0][0])) {
				
				
        while(!correctps)  
            {  System.out.print("Enter your current password: ");
                 password = input.next();
				 
			  if (password.equals(cred[0][1])) {
                    
                    
                System.out.println();
                    break;
            }
			
			else  {
                    System.out.println("invalid password. try again!");
                }
			}
				
             }	
            else {
                System.out.println("invalid username. try again!");
            }

            if(userName.equals (cred[0][0])&&password.equals(cred[0][1])){
				System.out.println("Enter your new password: ");
				newpass = input.next();
				cred[0][1] = newpass;
				
				System.out.println("Password changed successfully! Do you want to go home page (Y/N):			");
				char op = input.next().charAt(0);
				
				if(op == 'Y' || op == 'y'){
					clearConsole();
					homepage(input);
				}
				else if(op == 'N'|| op == 'n'){
					clearConsole();
					System.exit(0);
				}
				break;
			}
		}
     }
  

   public static void homepage(Scanner input){


        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|        WELCOME TO IJSE STOCK MANAGEMENT SYSTEM                    |");
        System.out.println("+-------------------------------------------------------------------+");

        System.out.print("[1] Change the Credentials");
        System.out.println("			[2] Supplier Manage");
        System.out.print("[3] Stock Manage");
        System.out.println("				[4] Log out");
        System.out.println("[5] Exit the System");

        System.out.println("Enter an option to continue >");
        int num = input.nextInt();

        if(num == 1){
			clearConsole();
			change();
		}
		else if(num ==2){
			clearConsole();
			supmanage();
		}
		else if(num == 3){
			clearConsole();
			stockmanage();
		}
		else if(num ==4){
			clearConsole();
			login(input); 
		}
		else if(num ==5){
			clearConsole();
			System.exit(0);
		}
		
    }


	public static void login(Scanner input){
		
		
		
		
        System.out.println("+-------------------------------------------------------------------+");
        System.out.println("|                        LOGIN PAGE                                 |");
        System.out.println("+-------------------------------------------------------------------+");


	
		while (!loggedIn) {
            System.out.print("User Name: ");
            userName = input.next();

              if (userName.equals(cred[0][0])) {
				
        while(!correctps){  
			System.out.print("Password: ");
                 password = input.next();
				 
			
			if (password.equals(cred[0][1])) {
             System.out.println();
                    break;
            }
			
			else {
                    System.out.println("Password is incorrect. Please try again!");
                }
			}
				
             }
            else {
                System.out.println("User name is invalid. Please try again!");
            }

            if(userName.equals (cred[0][0])&&password.equals(cred[0][1])){
				break;
			}
			
	}

			
		clearConsole();
		homepage(input);
        
     }
		
		
	 public static void main(String args[]) {
       Scanner input = new Scanner(System.in);
		cred[0][0] = "admin";
		cred[0][1] = "1234";

		login(input);
     }
  }			
