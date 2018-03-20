package RegionalOffice;


public final class AlarmDataHolder implements org.omg.CORBA.portable.Streamable
{
  public RegionalOffice.AlarmData value = null;

  public AlarmDataHolder ()
  {
  }

  public AlarmDataHolder (RegionalOffice.AlarmData initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.AlarmDataHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.AlarmDataHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.AlarmDataHelper.type ();
  }

}
