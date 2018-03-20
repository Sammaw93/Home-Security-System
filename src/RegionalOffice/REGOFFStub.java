package RegionalOffice;



public class REGOFFStub extends org.omg.CORBA.portable.ObjectImpl implements RegionalOffice.REGOFF
{

  public void raiseAlarm (RegionalOffice.Alarm anAlarm, RegionalOffice.Alarm aCamera)
  
  // Raising alarm
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("raiseAlarm", true);
                RegionalOffice.AlarmHelper.write ($out, anAlarm);
                RegionalOffice.AlarmHelper.write ($out, aCamera);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                raiseAlarm (anAlarm, aCamera        );
            } finally {
                _releaseReply ($in);
            }
  } 

  public void registerUser (RegionalOffice.userName user, RegionalOffice.contactDetails contact)
  {
	  
	  // Register User 
	  
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("registerUser", true);
                RegionalOffice.userNameHelper.write ($out, user);
                RegionalOffice.contactDetailsHelper.write ($out, contact);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                registerUser (user, contact        );
            } finally {
                _releaseReply ($in);
            }
  } 

  public void connectHOMEH (String homehName)
  
  // Connect HomeHub
  {
            org.omg.CORBA.portable.InputStream $in = null;
            try {
                org.omg.CORBA.portable.OutputStream $out = _request ("connectHOMEH", true);
                $out.write_string (homehName);
                $in = _invoke ($out);
                return;
            } catch (org.omg.CORBA.portable.ApplicationException $ex) {
                $in = $ex.getInputStream ();
                String _id = $ex.getId ();
                throw new org.omg.CORBA.MARSHAL (_id);
            } catch (org.omg.CORBA.portable.RemarshalException $rm) {
                connectHOMEH (homehName        );
            } finally {
                _releaseReply ($in);
            }
  } 

  // CORBA::Object operations
  private static String[] __ids = {
    "IDL:RegionalOffice/REGOFF:1.0"};

  public String[] _ids ()
  {
    return (String[])__ids.clone ();
  }

  private void readObject (java.io.ObjectInputStream s) throws java.io.IOException
  {
	  
// Read object
	  
     String str = s.readUTF ();
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     org.omg.CORBA.Object obj = orb.string_to_object (str);
     org.omg.CORBA.portable.Delegate delegate = ((org.omg.CORBA.portable.ObjectImpl) obj)._get_delegate ();
     _set_delegate (delegate);
   } finally {
     orb.destroy() ;
   }
  }

  private void writeObject (java.io.ObjectOutputStream s) throws java.io.IOException
  {
	  // Write object
	  
     String[] args = null;
     java.util.Properties props = null;
     org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init (args, props);
   try {
     String str = orb.object_to_string (this);
     s.writeUTF (str);
   } finally {
     orb.destroy() ;
   }
  }
} 
