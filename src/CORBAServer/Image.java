package CORBAServer;



public final class Image implements org.omg.CORBA.portable.IDLEntity
{
  public int time = (int)0;
  public int date = (int)0;
  public String imageMessage = null;

  public Image ()
  {
  } 

  public Image (int _time, int _date, String _imageMessage)
  {
    time = _time;
    date = _date;
    imageMessage = _imageMessage;
  } 

} 