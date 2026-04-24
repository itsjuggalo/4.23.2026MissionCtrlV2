package io.flutter.view;

import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import android.view.accessibility.AccessibilityRecord;
import androidx.annotation.Keep;
import io.flutter.Log;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes.dex */
@Keep
class AccessibilityViewEmbedder {
    private static final String TAG = "AccessibilityBridge";
    private int nextFlutterId;
    private final View rootAccessibilityView;
    private final ReflectionAccessors reflectionAccessors = new ReflectionAccessors();
    private final SparseArray<ViewAndId> flutterIdToOrigin = new SparseArray<>();
    private final Map<ViewAndId, Integer> originToFlutterId = new HashMap();
    private final Map<View, Rect> embeddedViewToDisplayBounds = new HashMap();

    public static class ReflectionAccessors {
        private final Field childNodeIdsField;
        private final Method getChildId;
        private final Method getParentNodeId;
        private final Method getRecordSourceNodeId;
        private final Method getSourceNodeId;
        private final Method longArrayGetIndex;

        /* JADX WARN: Multi-variable type inference failed */
        private ReflectionAccessors() throws NoSuchMethodException {
            Method method;
            Method method2;
            Method method3;
            Field field;
            Method method4;
            Method method5;
            Method method6 = null;
            try {
                method = AccessibilityNodeInfo.class.getMethod("getSourceNodeId", null);
            } catch (NoSuchMethodException unused) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibilityNodeInfo#getSourceNodeId with reflection");
                method = null;
            }
            try {
                method2 = AccessibilityRecord.class.getMethod("getSourceNodeId", null);
            } catch (NoSuchMethodException unused2) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke AccessibiiltyRecord#getSourceNodeId with reflection");
                method2 = null;
            }
            if (Build.VERSION.SDK_INT > 26) {
                try {
                    Field declaredField = AccessibilityNodeInfo.class.getDeclaredField("mChildNodeIds");
                    declaredField.setAccessible(true);
                    method4 = Class.forName("android.util.LongArray").getMethod(com.amazon.a.a.o.b.au, Integer.TYPE);
                    field = declaredField;
                    method3 = null;
                } catch (ClassNotFoundException | NoSuchFieldException | NoSuchMethodException | NullPointerException unused3) {
                    Log.w(AccessibilityViewEmbedder.TAG, "can't access childNodeIdsField with reflection");
                    method3 = null;
                    field = null;
                    method4 = field;
                }
                this.getSourceNodeId = method;
                this.getParentNodeId = method6;
                this.getRecordSourceNodeId = method2;
                this.getChildId = method3;
                this.childNodeIdsField = field;
                this.longArrayGetIndex = method4;
            }
            try {
                method5 = AccessibilityNodeInfo.class.getMethod("getParentNodeId", null);
            } catch (NoSuchMethodException unused4) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getParentNodeId with reflection");
                method5 = null;
            }
            try {
                method3 = AccessibilityNodeInfo.class.getMethod("getChildId", Integer.TYPE);
                field = null;
            } catch (NoSuchMethodException unused5) {
                Log.w(AccessibilityViewEmbedder.TAG, "can't invoke getChildId with reflection");
                method3 = null;
                field = null;
            }
            method6 = method5;
            method4 = field;
            this.getSourceNodeId = method;
            this.getParentNodeId = method6;
            this.getRecordSourceNodeId = method2;
            this.getChildId = method3;
            this.childNodeIdsField = field;
            this.longArrayGetIndex = method4;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long getChildId(AccessibilityNodeInfo accessibilityNodeInfo, int i8) {
            String str;
            Method method = this.getChildId;
            if (method == null && (this.childNodeIdsField == null || this.longArrayGetIndex == null)) {
                return null;
            }
            if (method != null) {
                try {
                    return (Long) method.invoke(accessibilityNodeInfo, Integer.valueOf(i8));
                } catch (IllegalAccessException e8) {
                    e = e8;
                    str = "Failed to access getChildId method.";
                } catch (InvocationTargetException e9) {
                    e = e9;
                    str = "The getChildId method threw an exception when invoked.";
                }
            } else {
                try {
                    Long l8 = (Long) this.longArrayGetIndex.invoke(this.childNodeIdsField.get(accessibilityNodeInfo), Integer.valueOf(i8));
                    l8.longValue();
                    return l8;
                } catch (ArrayIndexOutOfBoundsException e10) {
                    e = e10;
                    str = "The longArrayGetIndex method threw an exception when invoked.";
                    Log.w(AccessibilityViewEmbedder.TAG, str, e);
                    return null;
                } catch (IllegalAccessException e11) {
                    e = e11;
                    str = "Failed to access longArrayGetIndex method or the childNodeId field.";
                } catch (InvocationTargetException e12) {
                    e = e12;
                    str = "The longArrayGetIndex method threw an exception when invoked.";
                    Log.w(AccessibilityViewEmbedder.TAG, str, e);
                    return null;
                }
            }
            Log.w(AccessibilityViewEmbedder.TAG, str, e);
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long getParentNodeId(AccessibilityNodeInfo accessibilityNodeInfo) {
            String str;
            Method method = this.getParentNodeId;
            if (method != null) {
                try {
                    Long l8 = (Long) method.invoke(accessibilityNodeInfo, null);
                    l8.longValue();
                    return l8;
                } catch (IllegalAccessException e8) {
                    e = e8;
                    str = "Failed to access getParentNodeId method.";
                    Log.w(AccessibilityViewEmbedder.TAG, str, e);
                    return yoinkParentIdFromParcel(accessibilityNodeInfo);
                } catch (InvocationTargetException e9) {
                    e = e9;
                    str = "The getParentNodeId method threw an exception when invoked.";
                    Log.w(AccessibilityViewEmbedder.TAG, str, e);
                    return yoinkParentIdFromParcel(accessibilityNodeInfo);
                }
            }
            return yoinkParentIdFromParcel(accessibilityNodeInfo);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long getRecordSourceNodeId(AccessibilityRecord accessibilityRecord) {
            String str;
            Method method = this.getRecordSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityRecord, null);
            } catch (IllegalAccessException e8) {
                e = e8;
                str = "Failed to access the getRecordSourceNodeId method.";
                Log.w(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            } catch (InvocationTargetException e9) {
                e = e9;
                str = "The getRecordSourceNodeId method threw an exception when invoked.";
                Log.w(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Long getSourceNodeId(AccessibilityNodeInfo accessibilityNodeInfo) {
            String str;
            Method method = this.getSourceNodeId;
            if (method == null) {
                return null;
            }
            try {
                return (Long) method.invoke(accessibilityNodeInfo, null);
            } catch (IllegalAccessException e8) {
                e = e8;
                str = "Failed to access getSourceNodeId method.";
                Log.w(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            } catch (InvocationTargetException e9) {
                e = e9;
                str = "The getSourceNodeId method threw an exception when invoked.";
                Log.w(AccessibilityViewEmbedder.TAG, str, e);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static int getVirtualNodeId(long j8) {
            return (int) (j8 >> 32);
        }

        private static boolean isBitSet(long j8, int i8) {
            return (j8 & (1 << i8)) != 0;
        }

        private static Long yoinkParentIdFromParcel(AccessibilityNodeInfo accessibilityNodeInfo) {
            if (Build.VERSION.SDK_INT < 26) {
                Log.w(AccessibilityViewEmbedder.TAG, "Unexpected Android version. Unable to find the parent ID.");
                return null;
            }
            AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(accessibilityNodeInfo);
            Parcel parcelObtain = Parcel.obtain();
            parcelObtain.setDataPosition(0);
            accessibilityNodeInfoObtain.writeToParcel(parcelObtain, 0);
            parcelObtain.setDataPosition(0);
            long j8 = parcelObtain.readLong();
            if (isBitSet(j8, 0)) {
                parcelObtain.readInt();
            }
            if (isBitSet(j8, 1)) {
                parcelObtain.readLong();
            }
            if (isBitSet(j8, 2)) {
                parcelObtain.readInt();
            }
            Long lValueOf = isBitSet(j8, 3) ? Long.valueOf(parcelObtain.readLong()) : null;
            parcelObtain.recycle();
            return lValueOf;
        }
    }

    public static class ViewAndId {
        final int id;
        final View view;

        private ViewAndId(View view, int i8) {
            this.view = view;
            this.id = i8;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ViewAndId)) {
                return false;
            }
            ViewAndId viewAndId = (ViewAndId) obj;
            return this.id == viewAndId.id && this.view.equals(viewAndId.view);
        }

        public int hashCode() {
            return ((this.view.hashCode() + 31) * 31) + this.id;
        }
    }

    public AccessibilityViewEmbedder(View view, int i8) {
        this.rootAccessibilityView = view;
        this.nextFlutterId = i8;
    }

    private void addChildrenToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        int iIntValue;
        for (int i8 = 0; i8 < accessibilityNodeInfo.getChildCount(); i8++) {
            Long childId = this.reflectionAccessors.getChildId(accessibilityNodeInfo, i8);
            if (childId != null) {
                int virtualNodeId = ReflectionAccessors.getVirtualNodeId(childId.longValue());
                ViewAndId viewAndId = new ViewAndId(view, virtualNodeId);
                if (this.originToFlutterId.containsKey(viewAndId)) {
                    iIntValue = this.originToFlutterId.get(viewAndId).intValue();
                } else {
                    int i9 = this.nextFlutterId;
                    this.nextFlutterId = i9 + 1;
                    cacheVirtualIdMappings(view, virtualNodeId, i9);
                    iIntValue = i9;
                }
                accessibilityNodeInfo2.addChild(this.rootAccessibilityView, iIntValue);
            }
        }
    }

    private void cacheVirtualIdMappings(View view, int i8, int i9) {
        ViewAndId viewAndId = new ViewAndId(view, i8);
        this.originToFlutterId.put(viewAndId, Integer.valueOf(i9));
        this.flutterIdToOrigin.put(i9, viewAndId);
    }

    private AccessibilityNodeInfo convertToFlutterNode(AccessibilityNodeInfo accessibilityNodeInfo, int i8, View view) {
        AccessibilityNodeInfo accessibilityNodeInfoObtain = AccessibilityNodeInfo.obtain(this.rootAccessibilityView, i8);
        accessibilityNodeInfoObtain.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        accessibilityNodeInfoObtain.setSource(this.rootAccessibilityView, i8);
        accessibilityNodeInfoObtain.setClassName(accessibilityNodeInfo.getClassName());
        Rect rect = this.embeddedViewToDisplayBounds.get(view);
        copyAccessibilityFields(accessibilityNodeInfo, accessibilityNodeInfoObtain);
        setFlutterNodesTranslateBounds(accessibilityNodeInfo, rect, accessibilityNodeInfoObtain);
        addChildrenToFlutterNode(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        setFlutterNodeParent(accessibilityNodeInfo, view, accessibilityNodeInfoObtain);
        return accessibilityNodeInfoObtain;
    }

    private void copyAccessibilityFields(AccessibilityNodeInfo accessibilityNodeInfo, AccessibilityNodeInfo accessibilityNodeInfo2) {
        accessibilityNodeInfo2.setAccessibilityFocused(accessibilityNodeInfo.isAccessibilityFocused());
        accessibilityNodeInfo2.setCheckable(accessibilityNodeInfo.isCheckable());
        accessibilityNodeInfo2.setChecked(accessibilityNodeInfo.isChecked());
        accessibilityNodeInfo2.setContentDescription(accessibilityNodeInfo.getContentDescription());
        accessibilityNodeInfo2.setEnabled(accessibilityNodeInfo.isEnabled());
        accessibilityNodeInfo2.setClickable(accessibilityNodeInfo.isClickable());
        accessibilityNodeInfo2.setFocusable(accessibilityNodeInfo.isFocusable());
        accessibilityNodeInfo2.setFocused(accessibilityNodeInfo.isFocused());
        accessibilityNodeInfo2.setLongClickable(accessibilityNodeInfo.isLongClickable());
        accessibilityNodeInfo2.setMovementGranularities(accessibilityNodeInfo.getMovementGranularities());
        accessibilityNodeInfo2.setPassword(accessibilityNodeInfo.isPassword());
        accessibilityNodeInfo2.setScrollable(accessibilityNodeInfo.isScrollable());
        accessibilityNodeInfo2.setSelected(accessibilityNodeInfo.isSelected());
        accessibilityNodeInfo2.setText(accessibilityNodeInfo.getText());
        accessibilityNodeInfo2.setVisibleToUser(accessibilityNodeInfo.isVisibleToUser());
        accessibilityNodeInfo2.setEditable(accessibilityNodeInfo.isEditable());
        accessibilityNodeInfo2.setCanOpenPopup(accessibilityNodeInfo.canOpenPopup());
        accessibilityNodeInfo2.setCollectionInfo(accessibilityNodeInfo.getCollectionInfo());
        accessibilityNodeInfo2.setCollectionItemInfo(accessibilityNodeInfo.getCollectionItemInfo());
        accessibilityNodeInfo2.setContentInvalid(accessibilityNodeInfo.isContentInvalid());
        accessibilityNodeInfo2.setDismissable(accessibilityNodeInfo.isDismissable());
        accessibilityNodeInfo2.setInputType(accessibilityNodeInfo.getInputType());
        accessibilityNodeInfo2.setLiveRegion(accessibilityNodeInfo.getLiveRegion());
        accessibilityNodeInfo2.setMultiLine(accessibilityNodeInfo.isMultiLine());
        accessibilityNodeInfo2.setRangeInfo(accessibilityNodeInfo.getRangeInfo());
        accessibilityNodeInfo2.setError(accessibilityNodeInfo.getError());
        accessibilityNodeInfo2.setMaxTextLength(accessibilityNodeInfo.getMaxTextLength());
        int i8 = Build.VERSION.SDK_INT;
        accessibilityNodeInfo2.setContextClickable(accessibilityNodeInfo.isContextClickable());
        accessibilityNodeInfo2.setDrawingOrder(accessibilityNodeInfo.getDrawingOrder());
        accessibilityNodeInfo2.setImportantForAccessibility(accessibilityNodeInfo.isImportantForAccessibility());
        if (i8 >= 26) {
            accessibilityNodeInfo2.setAvailableExtraData(accessibilityNodeInfo.getAvailableExtraData());
            accessibilityNodeInfo2.setHintText(accessibilityNodeInfo.getHintText());
            accessibilityNodeInfo2.setShowingHintText(accessibilityNodeInfo.isShowingHintText());
        }
    }

    private void setFlutterNodeParent(AccessibilityNodeInfo accessibilityNodeInfo, View view, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Long parentNodeId = this.reflectionAccessors.getParentNodeId(accessibilityNodeInfo);
        if (parentNodeId == null) {
            return;
        }
        Integer num = this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(parentNodeId.longValue())));
        if (num != null) {
            accessibilityNodeInfo2.setParent(this.rootAccessibilityView, num.intValue());
        }
    }

    private void setFlutterNodesTranslateBounds(AccessibilityNodeInfo accessibilityNodeInfo, Rect rect, AccessibilityNodeInfo accessibilityNodeInfo2) {
        Rect rect2 = new Rect();
        accessibilityNodeInfo.getBoundsInParent(rect2);
        accessibilityNodeInfo2.setBoundsInParent(rect2);
        Rect rect3 = new Rect();
        accessibilityNodeInfo.getBoundsInScreen(rect3);
        rect3.offset(rect.left, rect.top);
        accessibilityNodeInfo2.setBoundsInScreen(rect3);
    }

    public AccessibilityNodeInfo createAccessibilityNodeInfo(int i8) {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i8);
        if (viewAndId == null || !this.embeddedViewToDisplayBounds.containsKey(viewAndId.view) || viewAndId.view.getAccessibilityNodeProvider() == null || (accessibilityNodeInfoCreateAccessibilityNodeInfo = viewAndId.view.getAccessibilityNodeProvider().createAccessibilityNodeInfo(viewAndId.id)) == null) {
            return null;
        }
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i8, viewAndId.view);
    }

    public Integer getRecordFlutterId(View view, AccessibilityRecord accessibilityRecord) {
        Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityRecord);
        if (recordSourceNodeId == null) {
            return null;
        }
        return this.originToFlutterId.get(new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue())));
    }

    public AccessibilityNodeInfo getRootNode(View view, int i8, Rect rect) {
        AccessibilityNodeInfo accessibilityNodeInfoCreateAccessibilityNodeInfo = view.createAccessibilityNodeInfo();
        Long sourceNodeId = this.reflectionAccessors.getSourceNodeId(accessibilityNodeInfoCreateAccessibilityNodeInfo);
        if (sourceNodeId == null) {
            return null;
        }
        this.embeddedViewToDisplayBounds.put(view, rect);
        cacheVirtualIdMappings(view, ReflectionAccessors.getVirtualNodeId(sourceNodeId.longValue()), i8);
        return convertToFlutterNode(accessibilityNodeInfoCreateAccessibilityNodeInfo, i8, view);
    }

    public boolean onAccessibilityHoverEvent(int i8, MotionEvent motionEvent) {
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i8);
        if (viewAndId == null) {
            return false;
        }
        Rect rect = this.embeddedViewToDisplayBounds.get(viewAndId.view);
        int pointerCount = motionEvent.getPointerCount();
        MotionEvent.PointerProperties[] pointerPropertiesArr = new MotionEvent.PointerProperties[pointerCount];
        MotionEvent.PointerCoords[] pointerCoordsArr = new MotionEvent.PointerCoords[pointerCount];
        for (int i9 = 0; i9 < motionEvent.getPointerCount(); i9++) {
            MotionEvent.PointerProperties pointerProperties = new MotionEvent.PointerProperties();
            pointerPropertiesArr[i9] = pointerProperties;
            motionEvent.getPointerProperties(i9, pointerProperties);
            MotionEvent.PointerCoords pointerCoords = new MotionEvent.PointerCoords();
            motionEvent.getPointerCoords(i9, pointerCoords);
            MotionEvent.PointerCoords pointerCoords2 = new MotionEvent.PointerCoords(pointerCoords);
            pointerCoordsArr[i9] = pointerCoords2;
            pointerCoords2.x -= rect.left;
            pointerCoords2.y -= rect.top;
        }
        return viewAndId.view.dispatchGenericMotionEvent(MotionEvent.obtain(motionEvent.getDownTime(), motionEvent.getEventTime(), motionEvent.getAction(), motionEvent.getPointerCount(), pointerPropertiesArr, pointerCoordsArr, motionEvent.getMetaState(), motionEvent.getButtonState(), motionEvent.getXPrecision(), motionEvent.getYPrecision(), motionEvent.getDeviceId(), motionEvent.getEdgeFlags(), motionEvent.getSource(), motionEvent.getFlags()));
    }

    public boolean performAction(int i8, int i9, Bundle bundle) {
        AccessibilityNodeProvider accessibilityNodeProvider;
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i8);
        if (viewAndId == null || (accessibilityNodeProvider = viewAndId.view.getAccessibilityNodeProvider()) == null) {
            return false;
        }
        return accessibilityNodeProvider.performAction(viewAndId.id, i9, bundle);
    }

    public View platformViewOfNode(int i8) {
        ViewAndId viewAndId = this.flutterIdToOrigin.get(i8);
        if (viewAndId == null) {
            return null;
        }
        return viewAndId.view;
    }

    public boolean requestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityEvent accessibilityEventObtain = AccessibilityEvent.obtain(accessibilityEvent);
        Long recordSourceNodeId = this.reflectionAccessors.getRecordSourceNodeId(accessibilityEvent);
        if (recordSourceNodeId == null) {
            return false;
        }
        int virtualNodeId = ReflectionAccessors.getVirtualNodeId(recordSourceNodeId.longValue());
        Integer num = this.originToFlutterId.get(new ViewAndId(view, virtualNodeId));
        if (num == null) {
            int i8 = this.nextFlutterId;
            this.nextFlutterId = i8 + 1;
            Integer numValueOf = Integer.valueOf(i8);
            cacheVirtualIdMappings(view, virtualNodeId, i8);
            num = numValueOf;
        }
        accessibilityEventObtain.setSource(this.rootAccessibilityView, num.intValue());
        accessibilityEventObtain.setClassName(accessibilityEvent.getClassName());
        accessibilityEventObtain.setPackageName(accessibilityEvent.getPackageName());
        for (int i9 = 0; i9 < accessibilityEventObtain.getRecordCount(); i9++) {
            AccessibilityRecord record = accessibilityEventObtain.getRecord(i9);
            Long recordSourceNodeId2 = this.reflectionAccessors.getRecordSourceNodeId(record);
            if (recordSourceNodeId2 == null) {
                return false;
            }
            ViewAndId viewAndId = new ViewAndId(view, ReflectionAccessors.getVirtualNodeId(recordSourceNodeId2.longValue()));
            if (!this.originToFlutterId.containsKey(viewAndId)) {
                return false;
            }
            record.setSource(this.rootAccessibilityView, this.originToFlutterId.get(viewAndId).intValue());
        }
        return this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(view2, accessibilityEventObtain);
    }
}
