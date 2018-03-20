package RegionalOffice;


public final class NotificationListHolder implements org.omg.CORBA.portable.Streamable
{
  public String value[] = null;

  public NotificationListHolder ()
  {
  }

  public NotificationListHolder (String[] initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = RegionalOffice.NotificationListHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    RegionalOffice.NotificationListHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return RegionalOffice.NotificationListHelper.type ();
  }

}
