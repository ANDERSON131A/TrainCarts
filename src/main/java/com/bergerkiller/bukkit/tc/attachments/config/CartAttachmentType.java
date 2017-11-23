package com.bergerkiller.bukkit.tc.attachments.config;

import com.bergerkiller.bukkit.tc.attachments.control.*;
import com.bergerkiller.mountiplex.MountiplexUtil;

public enum CartAttachmentType {
    /** Shows nothing, placeholder node */
    EMPTY(CartAttachmentEmpty.class),
    /** Shows the model of an entity */
    ENTITY(CartAttachmentEntity.class),
    /** Shows the model of an item in an armor stand */
    ITEM(CartAttachmentItem.class),
    /** A seat a player can sit in */
    SEAT(CartAttachmentSeat.class),
    /** Attaches the full model tree of another model to this one */
    MODEL(CartAttachmentEmpty.class);

    private final Class<? extends CartAttachment> attachmentClass;
    
    private CartAttachmentType(Class<? extends CartAttachment> attachmentClass) {
        this.attachmentClass = attachmentClass;
    }

    public CartAttachment createAttachment() {
        try {
            return this.attachmentClass.newInstance();
        } catch (Throwable t) {
            throw MountiplexUtil.uncheckedRethrow(t);
        }
    }
}