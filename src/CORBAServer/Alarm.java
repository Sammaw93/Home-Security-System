package CORBAServer;



public final class Alarm implements org.omg.CORBA.portable.IDLEntity
{
	
// sets the fields
	
	
  public String name = null;
  public String homeh = null;
  public int zone = (int)0;
  public boolean status = false;

  public Alarm ()
  {
  } 
  
  

  public Alarm (String _name, String _homeh, int _zone, boolean _status)
  {
    name = _name;
    homeh = _homeh;
    zone = _zone;
    status = _status;
  } 

} 
