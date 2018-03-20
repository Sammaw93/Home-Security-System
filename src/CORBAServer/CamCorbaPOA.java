package CORBAServer;




public abstract class CamCorbaPOA extends org.omg.PortableServer.Servant
 implements CORBAServer.CamCorbaOperations, org.omg.CORBA.portable.InvokeHandler
{


  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("_get_name", new java.lang.Integer (0));
    _methods.put ("currentStatus", new java.lang.Integer (1));
    _methods.put ("getAlarm", new java.lang.Integer (2));
    _methods.put ("CurrentImage", new java.lang.Integer (3));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CORBAServer/CamCorba/_get_name
       {
         String $result = null;
         $result = this.name ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 1:  // CORBAServer/CamCorba/currentStatus
       {
         boolean $result = false;
         $result = this.currentStatus ();
         out = $rh.createReply();
         out.write_boolean ($result);
         break;
       }

       case 2:  // CORBAServer/CamCorba/getAlarm
       {
         CORBAServer.Alarm $result = null;
         $result = this.getAlarm ();
         out = $rh.createReply();
         CORBAServer.AlarmHelper.write (out, $result);
         break;
       }

       case 3:  // CORBAServer/CamCorba/CurrentImage
       {
         CORBAServer.Image $result = null;
         $result = this.CurrentImage ();
         out = $rh.createReply();
         CORBAServer.ImageHelper.write (out, $result);
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } 

  // CORBA::Object operations
  private static String[] __ids = {
    "IDL:CORBAServer/CamCorba:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CamCorba _this() 
  {
    return CamCorbaHelper.narrow(
    super._this_object());
  }

  public CamCorba _this(org.omg.CORBA.ORB orb) 
  {
    return CamCorbaHelper.narrow(
    super._this_object(orb));
  }


} 
