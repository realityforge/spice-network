/*
 * Copyright (C) The Spice Group. All rights reserved.
 *
 * This software is published under the terms of the Spice
 * Software License version 1.1, a copy of which has been included
 * with this distribution in the LICENSE.txt file.
 */
package org.codehaus.spice.netevent.events;

import org.codehaus.spice.event.AbstractEvent;
import org.codehaus.spice.netevent.transport.ChannelTransport;

/**
 * An Event related to a particular transport.
 * 
 * @author Peter Donald
 * @version $Revision: 1.1.1.1 $ $Date: 2004/06/19 11:20:13 $
 */
public abstract class AbstractTransportEvent
    extends AbstractEvent
{
    /**
     * The transport.
     */
    private final ChannelTransport m_transport;

    /**
     * Create event for specified transport.
     * 
     * @param transport the transport
     */
    public AbstractTransportEvent( final ChannelTransport transport )
    {
        if( null == transport )
        {
            throw new NullPointerException( "transport" );
        }
        m_transport = transport;
    }

    /**
     * Return the transport.
     * 
     * @return the transport.
     */
    public ChannelTransport getTransport()
    {
        return m_transport;
    }

    /**
     * Return the description of event.
     * 
     * @return the description of event.
     */
    protected String getEventDescription()
    {
        return String.valueOf( getTransport() );
    }
}
