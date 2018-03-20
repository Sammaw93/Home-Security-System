package RegionalOffice;




abstract public class AlarmDataHelper
{
  private static String  _id = "IDL:RegionalOffice/AlarmData:1.0";

  public static void insert (org.omg.CORBA.Any a, RegionalOffice.AlarmData that)
  {
    org.omg.CORBA.portable.OutputStream out = a.create_output_stream ();
    a.type (type ());
    write (out, that);
    a.read_value (out.create_input_stream (), type ());
  }

  public static RegionalOffice.AlarmData extract (org.omg.CORBA.Any a)
  {
    return read (a.create_input_stream ());
  }

  private static org.omg.CORBA.TypeCode __typeCode = null;
  private static boolean __active = false;
  synchronized public static org.omg.CORBA.TypeCode type ()
  {
    if (__typeCode == null)
    {
      synchronized (org.omg.CORBA.TypeCode.class)
      {
        if (__typeCode == null)
        {
          if (__active)
          {
            return org.omg.CORBA.ORB.init().create_recursive_tc ( _id );
          }
          __active = true;
          org.omg.CORBA.StructMember[] _members0 = new org.omg.CORBA.StructMember [2];
          org.omg.CORBA.TypeCode _tcOf_members0 = null;
          _tcOf_members0 = RegionalOffice.AlarmHelper.type ();
          _members0[0] = new org.omg.CORBA.StructMember (
            "aReading",
            _tcOf_members0,
            null);
          _tcOf_members0 = RegionalOffice.AlarmHelper.type ();
          _members0[1] = new org.omg.CORBA.StructMember (
            "aConfirmingCamera",
            _tcOf_members0,
            null);
          __typeCode = org.omg.CORBA.ORB.init ().create_struct_tc (RegionalOffice.AlarmDataHelper.id (), "AlarmData", _members0);
          __active = false;
        }
      }
    }
    return __typeCode;
  }

  public static String id ()
  {
    return _id;
  }

  public static RegionalOffice.AlarmData read (org.omg.CORBA.portable.InputStream istream)
  {
    RegionalOffice.AlarmData value = new RegionalOffice.AlarmData ();
    value.aReading = RegionalOffice.AlarmHelper.read (istream);
    value.aConfirmingCamera = RegionalOffice.AlarmHelper.read (istream);
    return value;
  }

  public static void write (org.omg.CORBA.portable.OutputStream ostream, RegionalOffice.AlarmData value)
  {
    RegionalOffice.AlarmHelper.write (ostream, value.aReading);
    RegionalOffice.AlarmHelper.write (ostream, value.aConfirmingCamera);
  }

}
