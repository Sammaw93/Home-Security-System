package CORBAServer;


public final class ImageHolder implements org.omg.CORBA.portable.Streamable
{
  public CORBAServer.Image value = null;

  public ImageHolder ()
  {
  }

  public ImageHolder (CORBAServer.Image initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CORBAServer.ImageHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CORBAServer.ImageHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CORBAServer.ImageHelper.type ();
  }

}
