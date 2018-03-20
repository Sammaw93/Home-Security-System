package CORBAServer;



public final class AlarmHolder implements org.omg.CORBA.portable.Streamable
{
  public CORBAServer.Alarm value = null;

  public AlarmHolder ()
  {
  }

  public AlarmHolder (CORBAServer.Alarm initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CORBAServer.AlarmHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CORBAServer.AlarmHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CORBAServer.AlarmHelper.type ();
  }

}
