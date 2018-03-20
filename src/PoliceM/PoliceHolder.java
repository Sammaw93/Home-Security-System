package PoliceM;



public final class PoliceHolder implements org.omg.CORBA.portable.Streamable
{
  public PoliceM.Police value = null;

  public PoliceHolder ()
  {
  }

  public PoliceHolder (PoliceM.Police initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = PoliceM.PoliceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    PoliceM.PoliceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return PoliceM.PoliceHelper.type ();
  }

}
