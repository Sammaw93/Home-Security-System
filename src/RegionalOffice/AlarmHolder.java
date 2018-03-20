package RegionalOffice;



public final class AlarmHolder implements org.omg.CORBA.portable.Streamable
{
  public RegionalOffice.Alarm value = null;

  public AlarmHolder ()
  {
  }

  public AlarmHolder (RegionalOffice.Alarm initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.AlarmHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.AlarmHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.AlarmHelper.type ();
  }

}
