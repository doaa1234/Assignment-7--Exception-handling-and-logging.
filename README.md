# Assignment-7--Exception-handling-and-logging.

I did a job inside a method (getInsatnce)
	if(instance == null) {
			instance = new Ftp();
		}
		if(instance == null) {
			throw new ProtocolException("No connection is available");
		}
		return instance;
    
if instance = null throw  ProtocolException (No connection is available)

and job inside method (release)


Requirements:
4. Explain why the logger uses a singleton design pattern.


(logFile)We can use the logger utility class as a singleton and provide a global point of reference

It is to check whether there is an object or a class, if there is a similar one.
If there is no such thing, he will do a construction and work on returning it.
It means a return for the class or the object,,,,, but if there is a similar one for the class or the object,
he will not do a new by making a return for the object t(hat single, already-instantiated object, instead of creating a new one.)

(The basic idea is that the factory method will check to see if an instance of the object exists.
If it does not, it will create the object and return it. If the object already exists, 
the factory method will return that single, already-instantiated object, instead of creating a new one.)

And also No two users can use at the same time

(هو عشان بفحص ازا الكلاس او الابوجت 
ازا موجود زيو ازا ما كان موجود زيو فريح يعمل انشاء ويعمل على اعادتو يعني ريتيرن للكلاس او للاوبجكت ,,,, اما ازا كان في زيو للكلاس
او الاوبجت ما بعمل نيو بعمل ريتيرن للاوبجكت الي معمول زيوبدل ما يعمل نبو مره تانيه
ويكرر بلكود ويعمل يضل نيو ,وما بقدر اكتر من تنين يوزر يستعملوه بنفس الوقت ) 

