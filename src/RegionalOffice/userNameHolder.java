package RegionalOffice;


public final class userNameHolder implements org.omg.CORBA.portable.Streamable
{
  public RegionalOffice.userName value = null;

  public userNameHolder ()
  {
  }

  public userNameHolder (RegionalOffice.userName initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.userNameHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.userNameHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.userNameHelper.type ();
  }

}
