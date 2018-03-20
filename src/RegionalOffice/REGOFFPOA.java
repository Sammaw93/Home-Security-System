package RegionalOffice;


public abstract class REGOFFPOA extends org.omg.PortableServer.Servant
 implements RegionalOffice.REGOFFOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("raiseAlarm", new java.lang.Integer (0));
    _methods.put ("registerUser", new java.lang.Integer (1));
    _methods.put ("connectHOMEH", new java.lang.Integer (2));
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
       case 0:  // RegionalOffice/REGOFF/raiseAlarm
       {
         RegionalOffice.Alarm anAlarm = RegionalOffice.AlarmHelper.read (in);
         RegionalOffice.Alarm aCamera = RegionalOffice.AlarmHelper.read (in);
         this.raiseAlarm (anAlarm, aCamera);
         out = $rh.createReply();
         break;
       }

       case 1:  // RegionalOffice/REGOFF/registerUser
       {
         RegionalOffice.userName user = RegionalOffice.userNameHelper.read (in);
         RegionalOffice.contactDetails contact = RegionalOffice.contactDetailsHelper.read (in);
         this.registerUser (user, contact);
         out = $rh.createReply();
         break;
       }

       case 2:  // RegionalOffice/REGOFF/connectHOMEH
       {
         String homehName = in.read_string ();
         this.connectHOMEH (homehName);
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } 

  //CORBA::Object operations
  private static String[] __ids = {
    "IDL:RegionalOffice/REGOFF:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public REGOFF _this() 
  {
    return REGOFFHelper.narrow(
    super._this_object());
  }

  public REGOFF _this(org.omg.CORBA.ORB orb) 
  {
    return REGOFFHelper.narrow(
    super._this_object(orb));
  }


} 
