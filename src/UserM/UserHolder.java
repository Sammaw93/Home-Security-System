package UserM;



public final class UserHolder implements org.omg.CORBA.portable.Streamable
{
  public UserM.User value = null;

  public UserHolder ()
  {
  }

  public UserHolder (UserM.User initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = UserM.UserHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    UserM.UserHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return UserM.UserHelper.type ();
  }

}
