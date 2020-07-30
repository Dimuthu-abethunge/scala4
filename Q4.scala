object BankAccount extends App{

	var man1 = new Account("ID001", 1000, 10000);
	var man2 = new Account("ID002", 1500, 15000);	
	var man3 = new Account("ID003", 1200, -10);
	var man4 = new Account("ID004", 1300, -100);
	

	man4.transfer(man2, 3000);							//a method transfer which transfer the money from this account to a given account
	println("transfer Succesfull \n man2 to man4 3000");
	
	var bank:List[Account] = List(man1, man2, man3, man4);

	println("\n1. List of Accounts with negative balances: ");
	for (man <- bank) {
		man.negetive();
	}

		
	var summ:Double  = 0;
	for (man <- bank) {
		summ = summ + man.sum().asInstanceOf[Double];
	}
	println("\n2 Calculate the sum of all account balances: "+summ);
	
	println("\nCalculate the final balances of all accounts after apply the interest: "); 
	for (man <- bank) {
		println(man.inter());
	}

	
	//println(bank);

	//println(man1);
	//println(man2);
}

class Account(id:String, n:Int, b:Double){
	val nic:String = id;
	val accnumber:Int = n;
	var balance:Double = b; 

	def transfer(a:Account, b:Int) = { this.balance = this.balance + b;
					       a.balance = a.balance -b; } 
	def negetive()  = {if(this.balance < 0) println("["+ this.nic +" : "+ this.accnumber +" : "+ this.balance+ "]")};
	
	def sum() = {this.balance }

	def inter() = new Account(this.nic,this.accnumber,if(this.balance>0) this.balance*0.05 + this.balance else this.balance*0.1 + this.balance);
	

	override def toString = "["+ nic +" : "+ accnumber +" : "+ balance+ "]"; 
}