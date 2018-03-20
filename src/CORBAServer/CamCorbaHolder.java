package CORBAServer;


public final class CamCorbaHolder implements org.omg.CORBA.portable.Streamable
{
  public CORBAServer.CamCorba value = null;

  public CamCorbaHolder ()
  {
  }

  public CamCorbaHolder (CORBAServer.CamCorba initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CORBAServer.CamCorbaHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CORBAServer.CamCorbaHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CORBAServer.CamCorbaHelper.type ();
  }

}
