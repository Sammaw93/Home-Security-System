package RegionalOffice;



public final class contactDetailsHolder implements org.omg.CORBA.portable.Streamable
{
  public RegionalOffice.contactDetails value = null;

  public contactDetailsHolder ()
  {
  }

  public contactDetailsHolder (RegionalOffice.contactDetails initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.contactDetailsHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.contactDetailsHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.contactDetailsHelper.type ();
  }

}
