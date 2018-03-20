package RegionalOffice;




public final class contactDetails implements org.omg.CORBA.portable.IDLEntity
{
  public String address = null;
  public String postCode = null;
  public String telephone = null;

  public contactDetails ()
  {
  }

  public contactDetails (String _address, String _postCode, String _telephone)
  {
    address = _address;
    postCode = _postCode;
    telephone = _telephone;
  } 

} 
