object RationalAssignment extends App{
	val x = new Rational(3,4);
	val y = new Rational(5,8);
	val z = new Rational(2,7);

	println("Value: "+x.neg);

	val answer = (x.+(y.neg)).+(z.neg);
	println("Substraction using negative value = " + answer);
}

class Rational(n:Int, d:Int){
	def numer = n;
	def denom = d;
	
	def neg = new Rational(-this.numer, this.denom);
	
	def +(r:Rational) = new Rational(this.numer*r.denom+ this.denom*r.numer, this.denom*r.denom);

	def -(r:Rational) = this + r.neg;	

	override def toString =  numer + "/" + denom;
}