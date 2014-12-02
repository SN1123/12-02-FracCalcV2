// Write a class called RationalNumber that represents a fraction with an integer numerator and denominator
public class RationalNumber
{
  int numer;
  int denom;
  
  public RationalNumber ()
  {
    numer = 0;
    denom = 1;
  }
  public RationalNumber (int numerator, int denominator)
  {
    numer = numerator;
    
    if (denominator == 0)
    {
      denom = 1;
    }
    else if (denominator < 0)
    {
      numer = -numerator;
      denom = -denominator;
    }
    else
    {
      denom = denominator;
    }
  }
  public int getDenominator ()
  {
    return denom;
  }
  public int getNumerator ()
  {
    return numer;
  }
  public String toString ()
  {
    String result = "";
    if (numer%denom == 0)
    {
      result += numer/denom;
    }
    else
    {
      int GCF = GreatestCommonDivisor(numer, denom);
      result += numer/GCF + "/" + denom/GCF;
    }
    return result;
  }
  public void add (RationalNumber frac)
  {
    numer = numer*frac.getDenominator() + frac.getNumerator()*denom;
    denom = denom*frac.getDenominator();
  }
  public void subtract (RationalNumber frac)
  {
    numer = numer*frac.getDenominator() - frac.getNumerator()*denom;
    denom = denom*frac.getDenominator();    
  }
  public void multiply (RationalNumber frac)
  {
    numer = numer*frac.getNumerator();
    denom = denom*frac.getDenominator();
  }
  public void divide (RationalNumber frac)
  {
    numer = numer*frac.getDenominator();
    denom = denom*frac.getNumerator();    
  }
  // Euclid's algorithm - http://en.wikipedia.org/wiki/Euclidean_algorithm
  public int GreatestCommonDivisor(int first, int second) {
    int temp;
    while (second != 0) {
      temp = second;
      second = first % second;
      first = temp;
    }        
    return first;
  }
}
