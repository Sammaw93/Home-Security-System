package RegionalOffice;




public final class userName implements org.omg.CORBA.portable.IDLEntity
{
  public String firstName = null;
  public String lastName = null;

  public userName ()
  {
  } 

  public userName (String _firstName, String _lastName)
  {
    firstName = _firstName;
    lastName = _lastName;
  } 

}
