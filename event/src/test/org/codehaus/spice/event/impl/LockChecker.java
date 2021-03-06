package org.codehaus.spice.event.impl;

/**
 * @author Peter Donald
 * @version $Revision: 1.1.1.1 $ $Date: 2004/06/19 11:20:10 $
 */
class LockChecker
    implements Runnable
{
    private final Object _lock;
    private boolean _unlocked;
    private boolean _started;

    LockChecker( final Object lock )
    {
        _lock = lock;
        final Thread thread = new Thread( this );
        thread.start();
        while( !_started )
        {
            Thread.yield();
        }
    }

    public void run()
    {
        synchronized( _lock )
        {
            _started = true;
            try
            {
                _lock.wait();
                _unlocked = true;
            }
            catch( InterruptedException e )
            {
            }
        }
    }

    boolean isUnlocked()
    {
        try
        {
            Thread.sleep( 1 );
        }
        catch( InterruptedException e )
        {
        }
        return _unlocked;
    }
}
