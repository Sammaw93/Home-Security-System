package CORBAServer;



public interface CamCorbaOperations 
{
  String name ();
  boolean currentStatus ();
  CORBAServer.Alarm getAlarm ();
  CORBAServer.Image CurrentImage ();
} 
