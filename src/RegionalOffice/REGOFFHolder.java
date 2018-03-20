package RegionalOffice;



public final class REGOFFHolder implements org.omg.CORBA.portable.Streamable
{
  public RegionalOffice.REGOFF value = null;

  public REGOFFHolder ()
  {
  }

  public REGOFFHolder (RegionalOffice.REGOFF initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.REGOFFHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.REGOFFHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.REGOFFHelper.type ();
  }

}
