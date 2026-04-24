package io.flutter.view;

import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.graphics.Rect;
import android.net.Uri;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.LocaleSpan;
import android.text.style.TtsSpan;
import android.text.style.URLSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowInsets;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import io.flutter.Log;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.plugin.platform.PlatformViewsAccessibilityDelegate;
import io.flutter.util.Predicate;
import io.flutter.util.ViewUtils;
import io.flutter.view.AccessibilityBridge;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public class AccessibilityBridge extends AccessibilityNodeProvider {
    private static final int ACTION_SHOW_ON_SCREEN = 16908342;
    private static final int BOLD_TEXT_WEIGHT_ADJUSTMENT = 300;
    private static final float DEFAULT_TRANSITION_ANIMATION_SCALE = 1.0f;
    private static final float DISABLED_TRANSITION_ANIMATION_SCALE = 0.0f;
    private static final int MIN_ENGINE_GENERATED_NODE_ID = 65536;
    private static final int ROOT_NODE_ID = 0;
    private static final float SCROLL_EXTENT_FOR_INFINITY = 100000.0f;
    private static final float SCROLL_POSITION_CAP_FOR_INFINITY = 70000.0f;
    private static final String TAG = "AccessibilityBridge";
    private final AccessibilityChannel accessibilityChannel;
    private int accessibilityFeatureFlags;
    private SemanticsNode accessibilityFocusedSemanticsNode;
    private final AccessibilityManager accessibilityManager;
    private final AccessibilityChannel.AccessibilityMessageHandler accessibilityMessageHandler;
    private final AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener;
    private final AccessibilityViewEmbedder accessibilityViewEmbedder;
    private boolean accessibleNavigation;
    private final ContentObserver animationScaleObserver;
    private final ContentResolver contentResolver;
    private final Map<Integer, CustomAccessibilityAction> customAccessibilityActions;
    private Integer embeddedAccessibilityFocusedNodeId;
    private Integer embeddedInputFocusedNodeId;
    private final List<Integer> flutterNavigationStack;
    private final Map<Integer, SemanticsNode> flutterSemanticsTree;
    private SemanticsNode hoveredObject;
    private SemanticsNode inputFocusedSemanticsNode;
    private boolean isReleased;
    private SemanticsNode lastInputFocusedSemanticsNode;
    private Integer lastLeftFrameInset;
    private OnAccessibilityChangeListener onAccessibilityChangeListener;
    private final PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate;
    private int previousRouteId;
    private final View rootAccessibilityView;
    private final AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener;
    private static final int SCROLLABLE_ACTIONS = ((Action.SCROLL_RIGHT.value | Action.SCROLL_LEFT.value) | Action.SCROLL_UP.value) | Action.SCROLL_DOWN.value;
    private static final int FOCUSABLE_FLAGS = ((((((((((Flag.HAS_CHECKED_STATE.value | Flag.IS_CHECKED.value) | Flag.IS_SELECTED.value) | Flag.IS_TEXT_FIELD.value) | Flag.IS_FOCUSED.value) | Flag.HAS_ENABLED_STATE.value) | Flag.IS_ENABLED.value) | Flag.IS_IN_MUTUALLY_EXCLUSIVE_GROUP.value) | Flag.HAS_TOGGLED_STATE.value) | Flag.IS_TOGGLED.value) | Flag.IS_FOCUSABLE.value) | Flag.IS_SLIDER.value;
    private static int FIRST_RESOURCE_ID = 267386881;
    static int systemAction = (Action.DID_GAIN_ACCESSIBILITY_FOCUS.value & Action.DID_LOSE_ACCESSIBILITY_FOCUS.value) & Action.SHOW_ON_SCREEN.value;

    /* JADX INFO: renamed from: io.flutter.view.AccessibilityBridge$5, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType;

        static {
            int[] iArr = new int[StringAttributeType.values().length];
            $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType = iArr;
            try {
                iArr[StringAttributeType.SPELLOUT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[StringAttributeType.LOCALE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[StringAttributeType.URL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public enum AccessibilityFeature {
        ACCESSIBLE_NAVIGATION(1),
        INVERT_COLORS(2),
        DISABLE_ANIMATIONS(4),
        BOLD_TEXT(8),
        REDUCE_MOTION(16),
        HIGH_CONTRAST(32),
        ON_OFF_SWITCH_LABELS(64);

        final int value;

        AccessibilityFeature(int i8) {
            this.value = i8;
        }
    }

    public enum Action {
        TAP(1),
        LONG_PRESS(2),
        SCROLL_LEFT(4),
        SCROLL_RIGHT(8),
        SCROLL_UP(16),
        SCROLL_DOWN(32),
        INCREASE(64),
        DECREASE(128),
        SHOW_ON_SCREEN(256),
        MOVE_CURSOR_FORWARD_BY_CHARACTER(512),
        MOVE_CURSOR_BACKWARD_BY_CHARACTER(1024),
        SET_SELECTION(2048),
        COPY(4096),
        CUT(8192),
        PASTE(16384),
        DID_GAIN_ACCESSIBILITY_FOCUS(32768),
        DID_LOSE_ACCESSIBILITY_FOCUS(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        CUSTOM_ACTION(131072),
        DISMISS(262144),
        MOVE_CURSOR_FORWARD_BY_WORD(524288),
        MOVE_CURSOR_BACKWARD_BY_WORD(1048576),
        SET_TEXT(2097152),
        FOCUS(4194304),
        SCROLL_TO_OFFSET(8388608);

        public final int value;

        Action(int i8) {
            this.value = i8;
        }
    }

    public static class CustomAccessibilityAction {
        private String hint;
        private String label;
        private int resourceId = -1;
        private int id = -1;
        private int overrideId = -1;
    }

    public enum Flag {
        HAS_CHECKED_STATE(1),
        IS_CHECKED(2),
        IS_SELECTED(4),
        IS_BUTTON(8),
        IS_TEXT_FIELD(16),
        IS_FOCUSED(32),
        HAS_ENABLED_STATE(64),
        IS_ENABLED(128),
        IS_IN_MUTUALLY_EXCLUSIVE_GROUP(256),
        IS_HEADER(512),
        IS_OBSCURED(1024),
        SCOPES_ROUTE(2048),
        NAMES_ROUTE(4096),
        IS_HIDDEN(8192),
        IS_IMAGE(16384),
        IS_LIVE_REGION(32768),
        HAS_TOGGLED_STATE(AccessibilityBridge.MIN_ENGINE_GENERATED_NODE_ID),
        IS_TOGGLED(131072),
        HAS_IMPLICIT_SCROLLING(262144),
        IS_MULTILINE(524288),
        IS_READ_ONLY(1048576),
        IS_FOCUSABLE(2097152),
        IS_LINK(4194304),
        IS_SLIDER(8388608),
        IS_KEYBOARD_KEY(16777216),
        IS_CHECK_STATE_MIXED(33554432),
        HAS_EXPANDED_STATE(67108864),
        IS_EXPANDED(134217728),
        HAS_SELECTED_STATE(268435456),
        HAS_REQUIRED_STATE(536870912),
        IS_REQUIRED(1073741824);

        final int value;

        Flag(int i8) {
            this.value = i8;
        }
    }

    public static class LocaleStringAttribute extends StringAttribute {
        String locale;

        private LocaleStringAttribute() {
            super();
        }
    }

    public interface OnAccessibilityChangeListener {
        void onAccessibilityChanged(boolean z7, boolean z8);
    }

    public static class SemanticsNode {
        final AccessibilityBridge accessibilityBridge;
        private int actions;
        private float bottom;
        private int currentValueLength;
        private List<CustomAccessibilityAction> customAccessibilityActions;
        private String decreasedValue;
        private List<StringAttribute> decreasedValueAttributes;
        private int flags;
        private Rect globalRect;
        private float[] globalTransform;
        private String hint;
        private List<StringAttribute> hintAttributes;
        private String identifier;
        private String increasedValue;
        private List<StringAttribute> increasedValueAttributes;
        private float[] inverseTransform;
        private String label;
        private List<StringAttribute> labelAttributes;
        private float left;
        private String linkUrl;
        private int maxValueLength;
        private CustomAccessibilityAction onLongPressOverride;
        private CustomAccessibilityAction onTapOverride;
        private SemanticsNode parent;
        private int platformViewId;
        private int previousActions;
        private int previousFlags;
        private String previousLabel;
        private float previousScrollExtentMax;
        private float previousScrollExtentMin;
        private float previousScrollPosition;
        private int previousTextSelectionBase;
        private int previousTextSelectionExtent;
        private String previousValue;
        private float right;
        private int scrollChildren;
        private float scrollExtentMax;
        private float scrollExtentMin;
        private int scrollIndex;
        private float scrollPosition;
        private TextDirection textDirection;
        private int textSelectionBase;
        private int textSelectionExtent;
        private String tooltip;
        private float top;
        private float[] transform;
        private String value;
        private List<StringAttribute> valueAttributes;
        private int id = -1;
        private int previousNodeId = -1;
        private boolean hadPreviousConfig = false;
        private List<SemanticsNode> childrenInTraversalOrder = new ArrayList();
        private List<SemanticsNode> childrenInHitTestOrder = new ArrayList();
        private boolean inverseTransformDirty = true;
        private boolean globalGeometryDirty = true;

        public SemanticsNode(AccessibilityBridge accessibilityBridge) {
            this.accessibilityBridge = accessibilityBridge;
        }

        public static /* synthetic */ int access$2212(SemanticsNode semanticsNode, int i8) {
            int i9 = semanticsNode.textSelectionExtent + i8;
            semanticsNode.textSelectionExtent = i9;
            return i9;
        }

        public static /* synthetic */ int access$2220(SemanticsNode semanticsNode, int i8) {
            int i9 = semanticsNode.textSelectionExtent - i8;
            semanticsNode.textSelectionExtent = i9;
            return i9;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void collectRoutes(List<SemanticsNode> list) {
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                list.add(this);
            }
            Iterator<SemanticsNode> it = this.childrenInTraversalOrder.iterator();
            while (it.hasNext()) {
                it.next().collectRoutes(list);
            }
        }

        private SpannableString createSpannableString(String str, List<StringAttribute> list) {
            Object localeSpan;
            if (str == null) {
                return null;
            }
            SpannableString spannableString = new SpannableString(str);
            if (list != null) {
                for (StringAttribute stringAttribute : list) {
                    int i8 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttribute.type.ordinal()];
                    if (i8 != 1) {
                        if (i8 == 2) {
                            localeSpan = new LocaleSpan(Locale.forLanguageTag(((LocaleStringAttribute) stringAttribute).locale));
                        } else if (i8 == 3) {
                            localeSpan = new URLSpan(((UrlStringAttribute) stringAttribute).url);
                        }
                        spannableString.setSpan(localeSpan, stringAttribute.start, stringAttribute.end, 0);
                    } else {
                        spannableString.setSpan(new TtsSpan.Builder("android.type.verbatim").build(), stringAttribute.start, stringAttribute.end, 0);
                    }
                }
            }
            return spannableString;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didChangeLabel() {
            String str;
            String str2 = this.label;
            if (str2 == null && this.previousLabel == null) {
                return false;
            }
            return str2 == null || (str = this.previousLabel) == null || !str2.equals(str);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean didScroll() {
            return (Float.isNaN(this.scrollPosition) || Float.isNaN(this.previousScrollPosition) || this.previousScrollPosition == this.scrollPosition) ? false : true;
        }

        private void ensureInverseTransform() {
            if (this.inverseTransformDirty) {
                this.inverseTransformDirty = false;
                if (this.inverseTransform == null) {
                    this.inverseTransform = new float[16];
                }
                if (Matrix.invertM(this.inverseTransform, 0, this.transform, 0)) {
                    return;
                }
                Arrays.fill(this.inverseTransform, AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE);
            }
        }

        private SemanticsNode getAncestor(Predicate<SemanticsNode> predicate) {
            for (SemanticsNode semanticsNode = this.parent; semanticsNode != null; semanticsNode = semanticsNode.parent) {
                if (predicate.test(semanticsNode)) {
                    return semanticsNode;
                }
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public Rect getGlobalRect() {
            return this.globalRect;
        }

        private CharSequence getHint() {
            return createSpannableString(this.hint, this.hintAttributes);
        }

        private CharSequence getLabel() {
            List<StringAttribute> arrayList = this.labelAttributes;
            String str = this.linkUrl;
            if (str != null && str.length() > 0) {
                arrayList = arrayList == null ? new ArrayList<>() : new ArrayList<>(arrayList);
                UrlStringAttribute urlStringAttribute = new UrlStringAttribute();
                urlStringAttribute.start = 0;
                urlStringAttribute.end = this.label.length();
                urlStringAttribute.url = this.linkUrl;
                urlStringAttribute.type = StringAttributeType.URL;
                arrayList.add(urlStringAttribute);
            }
            return createSpannableString(this.label, arrayList);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public String getRouteName() {
            String str;
            if (hasFlag(Flag.NAMES_ROUTE) && (str = this.label) != null && !str.isEmpty()) {
                return this.label;
            }
            Iterator<SemanticsNode> it = this.childrenInTraversalOrder.iterator();
            while (it.hasNext()) {
                String routeName = it.next().getRouteName();
                if (routeName != null && !routeName.isEmpty()) {
                    return routeName;
                }
            }
            return null;
        }

        private List<StringAttribute> getStringAttributesFromBuffer(ByteBuffer byteBuffer, ByteBuffer[] byteBufferArr) {
            int i8 = byteBuffer.getInt();
            if (i8 == -1) {
                return null;
            }
            ArrayList arrayList = new ArrayList(i8);
            for (int i9 = 0; i9 < i8; i9++) {
                int i10 = byteBuffer.getInt();
                int i11 = byteBuffer.getInt();
                StringAttributeType stringAttributeType = StringAttributeType.values()[byteBuffer.getInt()];
                int i12 = AnonymousClass5.$SwitchMap$io$flutter$view$AccessibilityBridge$StringAttributeType[stringAttributeType.ordinal()];
                if (i12 == 1) {
                    byteBuffer.getInt();
                    SpellOutStringAttribute spellOutStringAttribute = new SpellOutStringAttribute();
                    spellOutStringAttribute.start = i10;
                    spellOutStringAttribute.end = i11;
                    spellOutStringAttribute.type = stringAttributeType;
                    arrayList.add(spellOutStringAttribute);
                } else if (i12 == 2) {
                    ByteBuffer byteBuffer2 = byteBufferArr[byteBuffer.getInt()];
                    LocaleStringAttribute localeStringAttribute = new LocaleStringAttribute();
                    localeStringAttribute.start = i10;
                    localeStringAttribute.end = i11;
                    localeStringAttribute.type = stringAttributeType;
                    localeStringAttribute.locale = Charset.forName("UTF-8").decode(byteBuffer2).toString();
                    arrayList.add(localeStringAttribute);
                }
            }
            return arrayList;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getTextFieldHint() {
            CharSequence[] charSequenceArr = {getLabel(), getHint()};
            CharSequence charSequenceConcat = null;
            for (int i8 = 0; i8 < 2; i8++) {
                CharSequence charSequence = charSequenceArr[i8];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getValue() {
            return createSpannableString(this.value, this.valueAttributes);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public CharSequence getValueLabelHint() {
            CharSequence[] charSequenceArr = {getValue(), getLabel(), getHint()};
            CharSequence charSequenceConcat = null;
            for (int i8 = 0; i8 < 3; i8++) {
                CharSequence charSequence = charSequenceArr[i8];
                if (charSequence != null && charSequence.length() > 0) {
                    charSequenceConcat = (charSequenceConcat == null || charSequenceConcat.length() == 0) ? charSequence : TextUtils.concat(charSequenceConcat, ", ", charSequence);
                }
            }
            return charSequenceConcat;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadAction(Action action) {
            return (action.value & this.previousActions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hadFlag(Flag flag) {
            return (flag.value & this.previousFlags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasAction(Action action) {
            return (action.value & this.actions) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean hasFlag(Flag flag) {
            return (flag.value & this.flags) != 0;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SemanticsNode hitTest(float[] fArr, boolean z7) {
            float f8 = fArr[3];
            boolean z8 = false;
            float f9 = fArr[0] / f8;
            float f10 = fArr[1] / f8;
            if (f9 < this.left || f9 >= this.right || f10 < this.top || f10 >= this.bottom) {
                return null;
            }
            float[] fArr2 = new float[4];
            for (SemanticsNode semanticsNode : this.childrenInHitTestOrder) {
                if (!semanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                    semanticsNode.ensureInverseTransform();
                    Matrix.multiplyMV(fArr2, 0, semanticsNode.inverseTransform, 0, fArr, 0);
                    SemanticsNode semanticsNodeHitTest = semanticsNode.hitTest(fArr2, z7);
                    if (semanticsNodeHitTest != null) {
                        return semanticsNodeHitTest;
                    }
                }
            }
            if (z7 && this.platformViewId != -1) {
                z8 = true;
            }
            if (isFocusable() || z8) {
                return this;
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public boolean isFocusable() {
            String str;
            String str2;
            String str3;
            if (hasFlag(Flag.SCOPES_ROUTE)) {
                return false;
            }
            if (hasFlag(Flag.IS_FOCUSABLE)) {
                return true;
            }
            return ((this.actions & (~AccessibilityBridge.SCROLLABLE_ACTIONS)) == 0 && (this.flags & AccessibilityBridge.FOCUSABLE_FLAGS) == 0 && ((str = this.label) == null || str.isEmpty()) && (((str2 = this.value) == null || str2.isEmpty()) && ((str3 = this.hint) == null || str3.isEmpty()))) ? false : true;
        }

        private void log(String str, boolean z7) {
        }

        private float max(float f8, float f9, float f10, float f11) {
            return Math.max(f8, Math.max(f9, Math.max(f10, f11)));
        }

        private float min(float f8, float f9, float f10, float f11) {
            return Math.min(f8, Math.min(f9, Math.min(f10, f11)));
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static boolean nullableHasAncestor(SemanticsNode semanticsNode, Predicate<SemanticsNode> predicate) {
            return (semanticsNode == null || semanticsNode.getAncestor(predicate) == null) ? false : true;
        }

        private void transformPoint(float[] fArr, float[] fArr2, float[] fArr3) {
            Matrix.multiplyMV(fArr, 0, fArr2, 0, fArr3, 0);
            float f8 = fArr[3];
            fArr[0] = fArr[0] / f8;
            fArr[1] = fArr[1] / f8;
            fArr[2] = fArr[2] / f8;
            fArr[3] = 0.0f;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateRecursively(float[] fArr, Set<SemanticsNode> set, boolean z7) {
            set.add(this);
            if (this.globalGeometryDirty) {
                z7 = true;
            }
            if (z7) {
                if (this.globalTransform == null) {
                    this.globalTransform = new float[16];
                }
                if (this.transform == null) {
                    this.transform = new float[16];
                }
                Matrix.multiplyMM(this.globalTransform, 0, fArr, 0, this.transform, 0);
                float[] fArr2 = {this.left, this.top, AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE, AccessibilityBridge.DEFAULT_TRANSITION_ANIMATION_SCALE};
                float[] fArr3 = new float[4];
                float[] fArr4 = new float[4];
                float[] fArr5 = new float[4];
                float[] fArr6 = new float[4];
                transformPoint(fArr3, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.top;
                transformPoint(fArr4, this.globalTransform, fArr2);
                fArr2[0] = this.right;
                fArr2[1] = this.bottom;
                transformPoint(fArr5, this.globalTransform, fArr2);
                fArr2[0] = this.left;
                fArr2[1] = this.bottom;
                transformPoint(fArr6, this.globalTransform, fArr2);
                if (this.globalRect == null) {
                    this.globalRect = new Rect();
                }
                this.globalRect.set(Math.round(min(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(min(fArr3[1], fArr4[1], fArr5[1], fArr6[1])), Math.round(max(fArr3[0], fArr4[0], fArr5[0], fArr6[0])), Math.round(max(fArr3[1], fArr4[1], fArr5[1], fArr6[1])));
                this.globalGeometryDirty = false;
            }
            int i8 = -1;
            for (SemanticsNode semanticsNode : this.childrenInTraversalOrder) {
                semanticsNode.previousNodeId = i8;
                i8 = semanticsNode.id;
                semanticsNode.updateRecursively(this.globalTransform, set, z7);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void updateWith(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
            this.hadPreviousConfig = true;
            this.previousValue = this.value;
            this.previousLabel = this.label;
            this.previousFlags = this.flags;
            this.previousActions = this.actions;
            this.previousTextSelectionBase = this.textSelectionBase;
            this.previousTextSelectionExtent = this.textSelectionExtent;
            this.previousScrollPosition = this.scrollPosition;
            this.previousScrollExtentMax = this.scrollExtentMax;
            this.previousScrollExtentMin = this.scrollExtentMin;
            this.flags = byteBuffer.getInt();
            this.actions = byteBuffer.getInt();
            this.maxValueLength = byteBuffer.getInt();
            this.currentValueLength = byteBuffer.getInt();
            this.textSelectionBase = byteBuffer.getInt();
            this.textSelectionExtent = byteBuffer.getInt();
            this.platformViewId = byteBuffer.getInt();
            this.scrollChildren = byteBuffer.getInt();
            this.scrollIndex = byteBuffer.getInt();
            this.scrollPosition = byteBuffer.getFloat();
            this.scrollExtentMax = byteBuffer.getFloat();
            this.scrollExtentMin = byteBuffer.getFloat();
            int i8 = byteBuffer.getInt();
            this.identifier = i8 == -1 ? null : strArr[i8];
            int i9 = byteBuffer.getInt();
            this.label = i9 == -1 ? null : strArr[i9];
            this.labelAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i10 = byteBuffer.getInt();
            this.value = i10 == -1 ? null : strArr[i10];
            this.valueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i11 = byteBuffer.getInt();
            this.increasedValue = i11 == -1 ? null : strArr[i11];
            this.increasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i12 = byteBuffer.getInt();
            this.decreasedValue = i12 == -1 ? null : strArr[i12];
            this.decreasedValueAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i13 = byteBuffer.getInt();
            this.hint = i13 == -1 ? null : strArr[i13];
            this.hintAttributes = getStringAttributesFromBuffer(byteBuffer, byteBufferArr);
            int i14 = byteBuffer.getInt();
            this.tooltip = i14 == -1 ? null : strArr[i14];
            int i15 = byteBuffer.getInt();
            this.linkUrl = i15 == -1 ? null : strArr[i15];
            this.textDirection = TextDirection.fromInt(byteBuffer.getInt());
            this.left = byteBuffer.getFloat();
            this.top = byteBuffer.getFloat();
            this.right = byteBuffer.getFloat();
            this.bottom = byteBuffer.getFloat();
            if (this.transform == null) {
                this.transform = new float[16];
            }
            for (int i16 = 0; i16 < 16; i16++) {
                this.transform[i16] = byteBuffer.getFloat();
            }
            this.inverseTransformDirty = true;
            this.globalGeometryDirty = true;
            int i17 = byteBuffer.getInt();
            this.childrenInTraversalOrder.clear();
            this.childrenInHitTestOrder.clear();
            for (int i18 = 0; i18 < i17; i18++) {
                SemanticsNode orCreateSemanticsNode = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode.parent = this;
                this.childrenInTraversalOrder.add(orCreateSemanticsNode);
            }
            for (int i19 = 0; i19 < i17; i19++) {
                SemanticsNode orCreateSemanticsNode2 = this.accessibilityBridge.getOrCreateSemanticsNode(byteBuffer.getInt());
                orCreateSemanticsNode2.parent = this;
                this.childrenInHitTestOrder.add(orCreateSemanticsNode2);
            }
            int i20 = byteBuffer.getInt();
            if (i20 == 0) {
                this.customAccessibilityActions = null;
                return;
            }
            List<CustomAccessibilityAction> list = this.customAccessibilityActions;
            if (list == null) {
                this.customAccessibilityActions = new ArrayList(i20);
            } else {
                list.clear();
            }
            for (int i21 = 0; i21 < i20; i21++) {
                CustomAccessibilityAction orCreateAccessibilityAction = this.accessibilityBridge.getOrCreateAccessibilityAction(byteBuffer.getInt());
                if (orCreateAccessibilityAction.overrideId == Action.TAP.value) {
                    this.onTapOverride = orCreateAccessibilityAction;
                } else if (orCreateAccessibilityAction.overrideId == Action.LONG_PRESS.value) {
                    this.onLongPressOverride = orCreateAccessibilityAction;
                } else {
                    this.customAccessibilityActions.add(orCreateAccessibilityAction);
                }
                this.customAccessibilityActions.add(orCreateAccessibilityAction);
            }
        }
    }

    public static class SpellOutStringAttribute extends StringAttribute {
        private SpellOutStringAttribute() {
            super();
        }
    }

    public static class StringAttribute {
        int end;
        int start;
        StringAttributeType type;

        private StringAttribute() {
        }
    }

    public enum StringAttributeType {
        SPELLOUT,
        LOCALE,
        URL
    }

    public enum TextDirection {
        UNKNOWN,
        LTR,
        RTL;

        public static TextDirection fromInt(int i8) {
            return i8 != 1 ? i8 != 2 ? UNKNOWN : LTR : RTL;
        }
    }

    public static class UrlStringAttribute extends StringAttribute {
        String url;

        private UrlStringAttribute() {
            super();
        }
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, AccessibilityManager accessibilityManager, ContentResolver contentResolver, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this(view, accessibilityChannel, accessibilityManager, contentResolver, new AccessibilityViewEmbedder(view, MIN_ENGINE_GENERATED_NODE_ID), platformViewsAccessibilityDelegate);
    }

    public static /* synthetic */ int access$1172(AccessibilityBridge accessibilityBridge, int i8) {
        int i9 = i8 & accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i9;
        return i9;
    }

    public static /* synthetic */ int access$1176(AccessibilityBridge accessibilityBridge, int i8) {
        int i9 = i8 | accessibilityBridge.accessibilityFeatureFlags;
        accessibilityBridge.accessibilityFeatureFlags = i9;
        return i9;
    }

    private AccessibilityEvent createTextChangedEvent(int i8, String str, String str2) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i8, 16);
        accessibilityEventObtainAccessibilityEvent.setBeforeText(str);
        accessibilityEventObtainAccessibilityEvent.getText().add(str2);
        int i9 = 0;
        while (i9 < str.length() && i9 < str2.length() && str.charAt(i9) == str2.charAt(i9)) {
            i9++;
        }
        if (i9 >= str.length() && i9 >= str2.length()) {
            return null;
        }
        accessibilityEventObtainAccessibilityEvent.setFromIndex(i9);
        int length = str.length() - 1;
        int length2 = str2.length() - 1;
        while (length >= i9 && length2 >= i9 && str.charAt(length) == str2.charAt(length2)) {
            length--;
            length2--;
        }
        accessibilityEventObtainAccessibilityEvent.setRemovedCount((length - i9) + 1);
        accessibilityEventObtainAccessibilityEvent.setAddedCount((length2 - i9) + 1);
        return accessibilityEventObtainAccessibilityEvent;
    }

    private boolean doesLayoutInDisplayCutoutModeRequireLeftInset() {
        Activity activity = ViewUtils.getActivity(this.rootAccessibilityView.getContext());
        if (activity == null || activity.getWindow() == null) {
            return false;
        }
        int i8 = activity.getWindow().getAttributes().layoutInDisplayCutoutMode;
        return i8 == 2 || i8 == 0;
    }

    private Rect getBoundsInScreen(Rect rect) {
        Rect rect2 = new Rect(rect);
        int[] iArr = new int[2];
        this.rootAccessibilityView.getLocationOnScreen(iArr);
        rect2.offset(iArr[0], iArr[1]);
        return rect2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public CustomAccessibilityAction getOrCreateAccessibilityAction(int i8) {
        CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i8));
        if (customAccessibilityAction != null) {
            return customAccessibilityAction;
        }
        CustomAccessibilityAction customAccessibilityAction2 = new CustomAccessibilityAction();
        customAccessibilityAction2.id = i8;
        customAccessibilityAction2.resourceId = FIRST_RESOURCE_ID + i8;
        this.customAccessibilityActions.put(Integer.valueOf(i8), customAccessibilityAction2);
        return customAccessibilityAction2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public SemanticsNode getOrCreateSemanticsNode(int i8) {
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i8));
        if (semanticsNode != null) {
            return semanticsNode;
        }
        SemanticsNode semanticsNode2 = new SemanticsNode(this);
        semanticsNode2.id = i8;
        this.flutterSemanticsTree.put(Integer.valueOf(i8), semanticsNode2);
        return semanticsNode2;
    }

    private SemanticsNode getRootSemanticsNode() {
        return this.flutterSemanticsTree.get(0);
    }

    private void handleTouchExploration(float f8, float f9, boolean z7) {
        SemanticsNode semanticsNodeHitTest;
        if (this.flutterSemanticsTree.isEmpty() || (semanticsNodeHitTest = getRootSemanticsNode().hitTest(new float[]{f8, f9, DISABLED_TRANSITION_ANIMATION_SCALE, DEFAULT_TRANSITION_ANIMATION_SCALE}, z7)) == this.hoveredObject) {
            return;
        }
        if (semanticsNodeHitTest != null) {
            sendAccessibilityEvent(semanticsNodeHitTest.id, 128);
        }
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
        }
        this.hoveredObject = semanticsNodeHitTest;
    }

    private boolean isImportant(SemanticsNode semanticsNode) {
        if (semanticsNode.hasFlag(Flag.SCOPES_ROUTE)) {
            return false;
        }
        return (semanticsNode.getValueLabelHint() == null && (semanticsNode.actions & (~systemAction)) == 0) ? false : true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$0(SemanticsNode semanticsNode, SemanticsNode semanticsNode2) {
        return semanticsNode2 == semanticsNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ boolean lambda$shouldSetCollectionInfo$1(SemanticsNode semanticsNode) {
        return semanticsNode.hasFlag(Flag.HAS_IMPLICIT_SCROLLING);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onTouchExplorationExit() {
        SemanticsNode semanticsNode = this.hoveredObject;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, 256);
            this.hoveredObject = null;
        }
    }

    private void onWindowNameChange(SemanticsNode semanticsNode) {
        String routeName = semanticsNode.getRouteName();
        if (routeName == null) {
            routeName = " ";
        }
        if (Build.VERSION.SDK_INT >= 28) {
            setAccessibilityPaneTitle(routeName);
            return;
        }
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 32);
        accessibilityEventObtainAccessibilityEvent.getText().add(routeName);
        sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
    }

    private boolean performCursorMoveAction(SemanticsNode semanticsNode, int i8, Bundle bundle, boolean z7) {
        int i9 = bundle.getInt("ACTION_ARGUMENT_MOVEMENT_GRANULARITY_INT");
        boolean z8 = bundle.getBoolean("ACTION_ARGUMENT_EXTEND_SELECTION_BOOLEAN");
        int i10 = semanticsNode.textSelectionBase;
        int i11 = semanticsNode.textSelectionExtent;
        predictCursorMovement(semanticsNode, i9, z7, z8);
        if (i10 != semanticsNode.textSelectionBase || i11 != semanticsNode.textSelectionExtent) {
            String str = semanticsNode.value != null ? semanticsNode.value : "";
            AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode.id, 8192);
            accessibilityEventObtainAccessibilityEvent.getText().add(str);
            accessibilityEventObtainAccessibilityEvent.setFromIndex(semanticsNode.textSelectionBase);
            accessibilityEventObtainAccessibilityEvent.setToIndex(semanticsNode.textSelectionExtent);
            accessibilityEventObtainAccessibilityEvent.setItemCount(str.length());
            sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
        }
        if (i9 == 1) {
            if (z7) {
                Action action = Action.MOVE_CURSOR_FORWARD_BY_CHARACTER;
                if (semanticsNode.hasAction(action)) {
                    this.accessibilityChannel.dispatchSemanticsAction(i8, action, Boolean.valueOf(z8));
                    return true;
                }
            }
            if (z7) {
                return false;
            }
            Action action2 = Action.MOVE_CURSOR_BACKWARD_BY_CHARACTER;
            if (!semanticsNode.hasAction(action2)) {
                return false;
            }
            this.accessibilityChannel.dispatchSemanticsAction(i8, action2, Boolean.valueOf(z8));
            return true;
        }
        if (i9 != 2) {
            return i9 == 4 || i9 == 8 || i9 == 16;
        }
        if (z7) {
            Action action3 = Action.MOVE_CURSOR_FORWARD_BY_WORD;
            if (semanticsNode.hasAction(action3)) {
                this.accessibilityChannel.dispatchSemanticsAction(i8, action3, Boolean.valueOf(z8));
                return true;
            }
        }
        if (z7) {
            return false;
        }
        Action action4 = Action.MOVE_CURSOR_BACKWARD_BY_WORD;
        if (!semanticsNode.hasAction(action4)) {
            return false;
        }
        this.accessibilityChannel.dispatchSemanticsAction(i8, action4, Boolean.valueOf(z8));
        return true;
    }

    private boolean performSetText(SemanticsNode semanticsNode, int i8, Bundle bundle) {
        String string = (bundle == null || !bundle.containsKey("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE")) ? "" : bundle.getString("ACTION_ARGUMENT_SET_TEXT_CHARSEQUENCE");
        this.accessibilityChannel.dispatchSemanticsAction(i8, Action.SET_TEXT, string);
        semanticsNode.value = string;
        semanticsNode.valueAttributes = null;
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        if (r6 != false) goto L19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x0024, code lost:
    
        r5 = r4.value.length();
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x002c, code lost:
    
        r4.textSelectionExtent = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0031, code lost:
    
        r4.textSelectionExtent = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0060, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0062, code lost:
    
        io.flutter.view.AccessibilityBridge.SemanticsNode.access$2212(r4, r5.start(1));
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x008d, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x008f, code lost:
    
        r5 = r5.start(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00c1, code lost:
    
        if (r5.find() != false) goto L27;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00e6, code lost:
    
        if (r5.find() != false) goto L33;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void predictCursorMovement(io.flutter.view.AccessibilityBridge.SemanticsNode r4, int r5, boolean r6, boolean r7) {
        /*
            Method dump skipped, instruction units count: 274
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.predictCursorMovement(io.flutter.view.AccessibilityBridge$SemanticsNode, int, boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendLatestAccessibilityFlagsToFlutter() {
        this.accessibilityChannel.setAccessibilityFeatures(this.accessibilityFeatureFlags);
    }

    private void sendWindowContentChangeEvent(int i8) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i8, 2048);
        accessibilityEventObtainAccessibilityEvent.setContentChangeTypes(1);
        sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
    }

    private void setAccessibilityPaneTitle(String str) {
        this.rootAccessibilityView.setAccessibilityPaneTitle(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setAccessibleNavigation(boolean z7) {
        if (this.accessibleNavigation == z7) {
            return;
        }
        this.accessibleNavigation = z7;
        this.accessibilityFeatureFlags = z7 ? this.accessibilityFeatureFlags | AccessibilityFeature.ACCESSIBLE_NAVIGATION.value : this.accessibilityFeatureFlags & (~AccessibilityFeature.ACCESSIBLE_NAVIGATION.value);
        sendLatestAccessibilityFlagsToFlutter();
    }

    private void setBoldTextFlag() {
        View view = this.rootAccessibilityView;
        if (view == null || view.getResources() == null) {
            return;
        }
        int i8 = this.rootAccessibilityView.getResources().getConfiguration().fontWeightAdjustment;
        this.accessibilityFeatureFlags = (i8 == Integer.MAX_VALUE || i8 < 300) ? this.accessibilityFeatureFlags & (~AccessibilityFeature.BOLD_TEXT.value) : this.accessibilityFeatureFlags | AccessibilityFeature.BOLD_TEXT.value;
        sendLatestAccessibilityFlagsToFlutter();
    }

    private boolean shouldSetCollectionInfo(final SemanticsNode semanticsNode) {
        return semanticsNode.scrollChildren > 0 && (SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: io.flutter.view.f
            @Override // io.flutter.util.Predicate
            public final boolean test(Object obj) {
                return AccessibilityBridge.lambda$shouldSetCollectionInfo$0(semanticsNode, (AccessibilityBridge.SemanticsNode) obj);
            }
        }) || !SemanticsNode.nullableHasAncestor(this.accessibilityFocusedSemanticsNode, new Predicate() { // from class: io.flutter.view.g
            @Override // io.flutter.util.Predicate
            public final boolean test(Object obj) {
                return AccessibilityBridge.lambda$shouldSetCollectionInfo$1((AccessibilityBridge.SemanticsNode) obj);
            }
        }));
    }

    private void willRemoveSemanticsNode(SemanticsNode semanticsNode) {
        View platformViewById;
        Integer num;
        semanticsNode.parent = null;
        if (semanticsNode.platformViewId != -1 && (num = this.embeddedAccessibilityFocusedNodeId) != null && this.accessibilityViewEmbedder.platformViewOfNode(num.intValue()) == this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) {
            sendAccessibilityEvent(this.embeddedAccessibilityFocusedNodeId.intValue(), MIN_ENGINE_GENERATED_NODE_ID);
            this.embeddedAccessibilityFocusedNodeId = null;
        }
        if (semanticsNode.platformViewId != -1 && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(semanticsNode.platformViewId)) != null) {
            platformViewById.setImportantForAccessibility(4);
        }
        SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode2 == semanticsNode) {
            sendAccessibilityEvent(semanticsNode2.id, MIN_ENGINE_GENERATED_NODE_ID);
            this.accessibilityFocusedSemanticsNode = null;
        }
        if (this.inputFocusedSemanticsNode == semanticsNode) {
            this.inputFocusedSemanticsNode = null;
        }
        if (this.hoveredObject == semanticsNode) {
            this.hoveredObject = null;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0286, code lost:
    
        if (r4.hasFlag(io.flutter.view.AccessibilityBridge.Flag.IS_SLIDER) != false) goto L125;
     */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x034d  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x0379  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x03e4  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x03fe  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x0417  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x0424  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x0430  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x046c  */
    @Override // android.view.accessibility.AccessibilityNodeProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public android.view.accessibility.AccessibilityNodeInfo createAccessibilityNodeInfo(int r14) {
        /*
            Method dump skipped, instruction units count: 1190
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.flutter.view.AccessibilityBridge.createAccessibilityNodeInfo(int):android.view.accessibility.AccessibilityNodeInfo");
    }

    public boolean externalViewRequestSendAccessibilityEvent(View view, View view2, AccessibilityEvent accessibilityEvent) {
        Integer recordFlutterId;
        if (!this.accessibilityViewEmbedder.requestSendAccessibilityEvent(view, view2, accessibilityEvent) || (recordFlutterId = this.accessibilityViewEmbedder.getRecordFlutterId(view, accessibilityEvent)) == null) {
            return false;
        }
        int eventType = accessibilityEvent.getEventType();
        if (eventType == 8) {
            this.embeddedInputFocusedNodeId = recordFlutterId;
            this.inputFocusedSemanticsNode = null;
            return true;
        }
        if (eventType == 128) {
            this.hoveredObject = null;
            return true;
        }
        if (eventType == 32768) {
            this.embeddedAccessibilityFocusedNodeId = recordFlutterId;
            this.accessibilityFocusedSemanticsNode = null;
            return true;
        }
        if (eventType != MIN_ENGINE_GENERATED_NODE_ID) {
            return true;
        }
        this.embeddedInputFocusedNodeId = null;
        this.embeddedAccessibilityFocusedNodeId = null;
        return true;
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public AccessibilityNodeInfo findFocus(int i8) {
        SemanticsNode semanticsNode;
        Integer num;
        int iIntValue;
        if (i8 == 1) {
            semanticsNode = this.inputFocusedSemanticsNode;
            if (semanticsNode == null) {
                num = this.embeddedInputFocusedNodeId;
                if (num == null) {
                }
                iIntValue = num.intValue();
                return createAccessibilityNodeInfo(iIntValue);
            }
            iIntValue = semanticsNode.id;
            return createAccessibilityNodeInfo(iIntValue);
        }
        if (i8 != 2) {
            return null;
        }
        semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode == null) {
            num = this.embeddedAccessibilityFocusedNodeId;
            if (num == null) {
                return null;
            }
            iIntValue = num.intValue();
            return createAccessibilityNodeInfo(iIntValue);
        }
        iIntValue = semanticsNode.id;
        return createAccessibilityNodeInfo(iIntValue);
    }

    public boolean getAccessibleNavigation() {
        return this.accessibleNavigation;
    }

    public int getHoveredObjectId() {
        return this.hoveredObject.id;
    }

    public boolean isAccessibilityEnabled() {
        return this.accessibilityManager.isEnabled();
    }

    public boolean isTouchExplorationEnabled() {
        return this.accessibilityManager.isTouchExplorationEnabled();
    }

    public AccessibilityEvent obtainAccessibilityEvent(int i8) {
        return AccessibilityEvent.obtain(i8);
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view) {
        return AccessibilityNodeInfo.obtain(view);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent) {
        return onAccessibilityHoverEvent(motionEvent, false);
    }

    @Override // android.view.accessibility.AccessibilityNodeProvider
    public boolean performAction(int i8, int i9, Bundle bundle) {
        int i10;
        if (i8 >= MIN_ENGINE_GENERATED_NODE_ID) {
            boolean zPerformAction = this.accessibilityViewEmbedder.performAction(i8, i9, bundle);
            if (zPerformAction && i9 == 128) {
                this.embeddedAccessibilityFocusedNodeId = null;
            }
            return zPerformAction;
        }
        SemanticsNode semanticsNode = this.flutterSemanticsTree.get(Integer.valueOf(i8));
        if (semanticsNode == null) {
            return false;
        }
        switch (i9) {
            case com.amazon.c.a.a.c.f14230g /* 16 */:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.TAP);
                return true;
            case 32:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.LONG_PRESS);
                return true;
            case 64:
                if (this.accessibilityFocusedSemanticsNode == null) {
                    this.rootAccessibilityView.invalidate();
                }
                this.accessibilityFocusedSemanticsNode = semanticsNode;
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.DID_GAIN_ACCESSIBILITY_FOCUS);
                HashMap map = new HashMap();
                map.put("type", "didGainFocus");
                map.put("nodeId", Integer.valueOf(semanticsNode.id));
                this.accessibilityChannel.channel.send(map);
                sendAccessibilityEvent(i8, 32768);
                if (semanticsNode.hasAction(Action.INCREASE) || semanticsNode.hasAction(Action.DECREASE)) {
                    sendAccessibilityEvent(i8, 4);
                }
                return true;
            case 128:
                SemanticsNode semanticsNode2 = this.accessibilityFocusedSemanticsNode;
                if (semanticsNode2 != null && semanticsNode2.id == i8) {
                    this.accessibilityFocusedSemanticsNode = null;
                }
                Integer num = this.embeddedAccessibilityFocusedNodeId;
                if (num != null && num.intValue() == i8) {
                    this.embeddedAccessibilityFocusedNodeId = null;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.DID_LOSE_ACCESSIBILITY_FOCUS);
                sendAccessibilityEvent(i8, MIN_ENGINE_GENERATED_NODE_ID);
                return true;
            case 256:
                return performCursorMoveAction(semanticsNode, i8, bundle, true);
            case 512:
                return performCursorMoveAction(semanticsNode, i8, bundle, false);
            case 4096:
                Action action = Action.SCROLL_UP;
                if (!semanticsNode.hasAction(action)) {
                    action = Action.SCROLL_LEFT;
                    if (!semanticsNode.hasAction(action)) {
                        action = Action.INCREASE;
                        if (!semanticsNode.hasAction(action)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.increasedValue;
                        semanticsNode.valueAttributes = semanticsNode.increasedValueAttributes;
                        sendAccessibilityEvent(i8, 4);
                    }
                }
                this.accessibilityChannel.dispatchSemanticsAction(i8, action);
                return true;
            case 8192:
                Action action2 = Action.SCROLL_DOWN;
                if (!semanticsNode.hasAction(action2)) {
                    action2 = Action.SCROLL_RIGHT;
                    if (!semanticsNode.hasAction(action2)) {
                        action2 = Action.DECREASE;
                        if (!semanticsNode.hasAction(action2)) {
                            return false;
                        }
                        semanticsNode.value = semanticsNode.decreasedValue;
                        semanticsNode.valueAttributes = semanticsNode.decreasedValueAttributes;
                        sendAccessibilityEvent(i8, 4);
                    }
                }
                this.accessibilityChannel.dispatchSemanticsAction(i8, action2);
                return true;
            case 16384:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.COPY);
                return true;
            case 32768:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.PASTE);
                return true;
            case MIN_ENGINE_GENERATED_NODE_ID /* 65536 */:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.CUT);
                return true;
            case 131072:
                HashMap map2 = new HashMap();
                if (bundle != null && bundle.containsKey("ACTION_ARGUMENT_SELECTION_START_INT") && bundle.containsKey("ACTION_ARGUMENT_SELECTION_END_INT")) {
                    map2.put("base", Integer.valueOf(bundle.getInt("ACTION_ARGUMENT_SELECTION_START_INT")));
                    i10 = bundle.getInt("ACTION_ARGUMENT_SELECTION_END_INT");
                } else {
                    map2.put("base", Integer.valueOf(semanticsNode.textSelectionExtent));
                    i10 = semanticsNode.textSelectionExtent;
                }
                map2.put("extent", Integer.valueOf(i10));
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.SET_SELECTION, map2);
                SemanticsNode semanticsNode3 = this.flutterSemanticsTree.get(Integer.valueOf(i8));
                semanticsNode3.textSelectionBase = ((Integer) map2.get("base")).intValue();
                semanticsNode3.textSelectionExtent = ((Integer) map2.get("extent")).intValue();
                return true;
            case 1048576:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.DISMISS);
                return true;
            case 2097152:
                return performSetText(semanticsNode, i8, bundle);
            case 16908342:
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.SHOW_ON_SCREEN);
                return true;
            default:
                CustomAccessibilityAction customAccessibilityAction = this.customAccessibilityActions.get(Integer.valueOf(i9 - FIRST_RESOURCE_ID));
                if (customAccessibilityAction == null) {
                    return false;
                }
                this.accessibilityChannel.dispatchSemanticsAction(i8, Action.CUSTOM_ACTION, Integer.valueOf(customAccessibilityAction.id));
                return true;
        }
    }

    public void release() {
        this.isReleased = true;
        this.platformViewsAccessibilityDelegate.detachAccessibilityBridge();
        setOnAccessibilityChangeListener(null);
        this.accessibilityManager.removeAccessibilityStateChangeListener(this.accessibilityStateChangeListener);
        this.accessibilityManager.removeTouchExplorationStateChangeListener(this.touchExplorationStateChangeListener);
        this.contentResolver.unregisterContentObserver(this.animationScaleObserver);
        this.accessibilityChannel.setAccessibilityMessageHandler(null);
    }

    public void reset() {
        this.flutterSemanticsTree.clear();
        SemanticsNode semanticsNode = this.accessibilityFocusedSemanticsNode;
        if (semanticsNode != null) {
            sendAccessibilityEvent(semanticsNode.id, MIN_ENGINE_GENERATED_NODE_ID);
        }
        this.accessibilityFocusedSemanticsNode = null;
        this.hoveredObject = null;
        sendWindowContentChangeEvent(0);
    }

    public void sendAccessibilityEvent(int i8, int i9) {
        if (this.accessibilityManager.isEnabled()) {
            sendAccessibilityEvent(obtainAccessibilityEvent(i8, i9));
        }
    }

    public void setOnAccessibilityChangeListener(OnAccessibilityChangeListener onAccessibilityChangeListener) {
        this.onAccessibilityChangeListener = onAccessibilityChangeListener;
    }

    public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
        while (byteBuffer.hasRemaining()) {
            CustomAccessibilityAction orCreateAccessibilityAction = getOrCreateAccessibilityAction(byteBuffer.getInt());
            orCreateAccessibilityAction.overrideId = byteBuffer.getInt();
            int i8 = byteBuffer.getInt();
            String str = null;
            orCreateAccessibilityAction.label = i8 == -1 ? null : strArr[i8];
            int i9 = byteBuffer.getInt();
            if (i9 != -1) {
                str = strArr[i9];
            }
            orCreateAccessibilityAction.hint = str;
        }
    }

    public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
        SemanticsNode semanticsNode;
        SemanticsNode semanticsNode2;
        float f8;
        float f9;
        WindowInsets rootWindowInsets;
        View platformViewById;
        ArrayList<SemanticsNode> arrayList = new ArrayList();
        while (byteBuffer.hasRemaining()) {
            SemanticsNode orCreateSemanticsNode = getOrCreateSemanticsNode(byteBuffer.getInt());
            orCreateSemanticsNode.updateWith(byteBuffer, strArr, byteBufferArr);
            if (!orCreateSemanticsNode.hasFlag(Flag.IS_HIDDEN)) {
                if (orCreateSemanticsNode.hasFlag(Flag.IS_FOCUSED)) {
                    this.inputFocusedSemanticsNode = orCreateSemanticsNode;
                }
                if (orCreateSemanticsNode.hadPreviousConfig) {
                    arrayList.add(orCreateSemanticsNode);
                }
                if (orCreateSemanticsNode.platformViewId != -1 && !this.platformViewsAccessibilityDelegate.usesVirtualDisplay(orCreateSemanticsNode.platformViewId) && (platformViewById = this.platformViewsAccessibilityDelegate.getPlatformViewById(orCreateSemanticsNode.platformViewId)) != null) {
                    platformViewById.setImportantForAccessibility(0);
                }
            }
        }
        HashSet hashSet = new HashSet();
        SemanticsNode rootSemanticsNode = getRootSemanticsNode();
        ArrayList<SemanticsNode> arrayList2 = new ArrayList();
        if (rootSemanticsNode != null) {
            float[] fArr = new float[16];
            Matrix.setIdentityM(fArr, 0);
            if ((Build.VERSION.SDK_INT >= 28 ? doesLayoutInDisplayCutoutModeRequireLeftInset() : true) && (rootWindowInsets = this.rootAccessibilityView.getRootWindowInsets()) != null) {
                if (!this.lastLeftFrameInset.equals(Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft()))) {
                    rootSemanticsNode.globalGeometryDirty = true;
                    rootSemanticsNode.inverseTransformDirty = true;
                }
                this.lastLeftFrameInset = Integer.valueOf(rootWindowInsets.getSystemWindowInsetLeft());
                Matrix.translateM(fArr, 0, r4.intValue(), DISABLED_TRANSITION_ANIMATION_SCALE, DISABLED_TRANSITION_ANIMATION_SCALE);
            }
            rootSemanticsNode.updateRecursively(fArr, hashSet, false);
            rootSemanticsNode.collectRoutes(arrayList2);
        }
        SemanticsNode semanticsNode3 = null;
        for (SemanticsNode semanticsNode4 : arrayList2) {
            if (!this.flutterNavigationStack.contains(Integer.valueOf(semanticsNode4.id))) {
                semanticsNode3 = semanticsNode4;
            }
        }
        if (semanticsNode3 == null && arrayList2.size() > 0) {
            semanticsNode3 = (SemanticsNode) arrayList2.get(arrayList2.size() - 1);
        }
        if (semanticsNode3 != null && (semanticsNode3.id != this.previousRouteId || arrayList2.size() != this.flutterNavigationStack.size())) {
            this.previousRouteId = semanticsNode3.id;
            onWindowNameChange(semanticsNode3);
        }
        this.flutterNavigationStack.clear();
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            this.flutterNavigationStack.add(Integer.valueOf(((SemanticsNode) it.next()).id));
        }
        Iterator<Map.Entry<Integer, SemanticsNode>> it2 = this.flutterSemanticsTree.entrySet().iterator();
        while (it2.hasNext()) {
            SemanticsNode value = it2.next().getValue();
            if (!hashSet.contains(value)) {
                willRemoveSemanticsNode(value);
                it2.remove();
            }
        }
        sendWindowContentChangeEvent(0);
        for (SemanticsNode semanticsNode5 : arrayList) {
            if (semanticsNode5.didScroll()) {
                AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(semanticsNode5.id, 4096);
                float f10 = semanticsNode5.scrollPosition;
                float f11 = semanticsNode5.scrollExtentMax;
                if (Float.isInfinite(semanticsNode5.scrollExtentMax)) {
                    if (f10 > SCROLL_POSITION_CAP_FOR_INFINITY) {
                        f10 = 70000.0f;
                    }
                    f11 = 100000.0f;
                }
                if (Float.isInfinite(semanticsNode5.scrollExtentMin)) {
                    f8 = f11 + SCROLL_EXTENT_FOR_INFINITY;
                    if (f10 < -70000.0f) {
                        f10 = -70000.0f;
                    }
                    f9 = f10 + SCROLL_EXTENT_FOR_INFINITY;
                } else {
                    f8 = f11 - semanticsNode5.scrollExtentMin;
                    f9 = f10 - semanticsNode5.scrollExtentMin;
                }
                if (semanticsNode5.hadAction(Action.SCROLL_UP) || semanticsNode5.hadAction(Action.SCROLL_DOWN)) {
                    accessibilityEventObtainAccessibilityEvent.setScrollY((int) f9);
                    accessibilityEventObtainAccessibilityEvent.setMaxScrollY((int) f8);
                } else if (semanticsNode5.hadAction(Action.SCROLL_LEFT) || semanticsNode5.hadAction(Action.SCROLL_RIGHT)) {
                    accessibilityEventObtainAccessibilityEvent.setScrollX((int) f9);
                    accessibilityEventObtainAccessibilityEvent.setMaxScrollX((int) f8);
                }
                if (semanticsNode5.scrollChildren > 0) {
                    accessibilityEventObtainAccessibilityEvent.setItemCount(semanticsNode5.scrollChildren);
                    accessibilityEventObtainAccessibilityEvent.setFromIndex(semanticsNode5.scrollIndex);
                    Iterator it3 = semanticsNode5.childrenInHitTestOrder.iterator();
                    int i8 = 0;
                    while (it3.hasNext()) {
                        if (!((SemanticsNode) it3.next()).hasFlag(Flag.IS_HIDDEN)) {
                            i8++;
                        }
                    }
                    accessibilityEventObtainAccessibilityEvent.setToIndex((semanticsNode5.scrollIndex + i8) - 1);
                }
                sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
            }
            if (semanticsNode5.hasFlag(Flag.IS_LIVE_REGION) && semanticsNode5.didChangeLabel()) {
                sendWindowContentChangeEvent(semanticsNode5.id);
            }
            SemanticsNode semanticsNode6 = this.accessibilityFocusedSemanticsNode;
            if (semanticsNode6 != null && semanticsNode6.id == semanticsNode5.id) {
                Flag flag = Flag.IS_SELECTED;
                if (!semanticsNode5.hadFlag(flag) && semanticsNode5.hasFlag(flag)) {
                    AccessibilityEvent accessibilityEventObtainAccessibilityEvent2 = obtainAccessibilityEvent(semanticsNode5.id, 4);
                    accessibilityEventObtainAccessibilityEvent2.getText().add(semanticsNode5.label);
                    sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent2);
                }
            }
            SemanticsNode semanticsNode7 = this.inputFocusedSemanticsNode;
            if (semanticsNode7 != null && semanticsNode7.id == semanticsNode5.id && ((semanticsNode2 = this.lastInputFocusedSemanticsNode) == null || semanticsNode2.id != this.inputFocusedSemanticsNode.id)) {
                this.lastInputFocusedSemanticsNode = this.inputFocusedSemanticsNode;
                sendAccessibilityEvent(obtainAccessibilityEvent(semanticsNode5.id, 8));
            } else if (this.inputFocusedSemanticsNode == null) {
                this.lastInputFocusedSemanticsNode = null;
            }
            SemanticsNode semanticsNode8 = this.inputFocusedSemanticsNode;
            if (semanticsNode8 != null && semanticsNode8.id == semanticsNode5.id) {
                Flag flag2 = Flag.IS_TEXT_FIELD;
                if (semanticsNode5.hadFlag(flag2) && semanticsNode5.hasFlag(flag2) && ((semanticsNode = this.accessibilityFocusedSemanticsNode) == null || semanticsNode.id == this.inputFocusedSemanticsNode.id)) {
                    String str = semanticsNode5.previousValue != null ? semanticsNode5.previousValue : "";
                    String str2 = semanticsNode5.value != null ? semanticsNode5.value : "";
                    AccessibilityEvent accessibilityEventCreateTextChangedEvent = createTextChangedEvent(semanticsNode5.id, str, str2);
                    if (accessibilityEventCreateTextChangedEvent != null) {
                        sendAccessibilityEvent(accessibilityEventCreateTextChangedEvent);
                    }
                    if (semanticsNode5.previousTextSelectionBase != semanticsNode5.textSelectionBase || semanticsNode5.previousTextSelectionExtent != semanticsNode5.textSelectionExtent) {
                        AccessibilityEvent accessibilityEventObtainAccessibilityEvent3 = obtainAccessibilityEvent(semanticsNode5.id, 8192);
                        accessibilityEventObtainAccessibilityEvent3.getText().add(str2);
                        accessibilityEventObtainAccessibilityEvent3.setFromIndex(semanticsNode5.textSelectionBase);
                        accessibilityEventObtainAccessibilityEvent3.setToIndex(semanticsNode5.textSelectionExtent);
                        accessibilityEventObtainAccessibilityEvent3.setItemCount(str2.length());
                        sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent3);
                    }
                }
            }
        }
    }

    public AccessibilityBridge(View view, AccessibilityChannel accessibilityChannel, final AccessibilityManager accessibilityManager, ContentResolver contentResolver, AccessibilityViewEmbedder accessibilityViewEmbedder, PlatformViewsAccessibilityDelegate platformViewsAccessibilityDelegate) {
        this.flutterSemanticsTree = new HashMap();
        this.customAccessibilityActions = new HashMap();
        this.accessibilityFeatureFlags = 0;
        this.flutterNavigationStack = new ArrayList();
        this.previousRouteId = 0;
        this.lastLeftFrameInset = 0;
        this.accessibleNavigation = false;
        this.isReleased = false;
        this.accessibilityMessageHandler = new AccessibilityChannel.AccessibilityMessageHandler() { // from class: io.flutter.view.AccessibilityBridge.1
            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void announce(String str) {
                if (Build.VERSION.SDK_INT >= 36) {
                    Log.w(AccessibilityBridge.TAG, "Using AnnounceSemanticsEvent for accessibility is deprecated on Android. Migrate to using semantic properties for a more robust and accessible user experience.\nFlutter: If you are unsure why you are seeing this bug, it might be because you are using a widget that calls this method. See https://github.com/flutter/flutter/issues/165510 for more details.\nAndroid documentation: https://developer.android.com/reference/android/view/View#announceForAccessibility(java.lang.CharSequence)");
                }
                AccessibilityBridge.this.rootAccessibilityView.announceForAccessibility(str);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onFocus(int i8) {
                AccessibilityBridge.this.sendAccessibilityEvent(i8, 8);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onLongPress(int i8) {
                AccessibilityBridge.this.sendAccessibilityEvent(i8, 2);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTap(int i8) {
                AccessibilityBridge.this.sendAccessibilityEvent(i8, 1);
            }

            @Override // io.flutter.embedding.engine.systemchannels.AccessibilityChannel.AccessibilityMessageHandler
            public void onTooltip(String str) {
                if (Build.VERSION.SDK_INT >= 28) {
                    return;
                }
                AccessibilityEvent accessibilityEventObtainAccessibilityEvent = AccessibilityBridge.this.obtainAccessibilityEvent(0, 32);
                accessibilityEventObtainAccessibilityEvent.getText().add(str);
                AccessibilityBridge.this.sendAccessibilityEvent(accessibilityEventObtainAccessibilityEvent);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateCustomAccessibilityActions(ByteBuffer byteBuffer, String[] strArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                AccessibilityBridge.this.updateCustomAccessibilityActions(byteBuffer, strArr);
            }

            @Override // io.flutter.embedding.engine.FlutterJNI.AccessibilityDelegate
            public void updateSemantics(ByteBuffer byteBuffer, String[] strArr, ByteBuffer[] byteBufferArr) {
                byteBuffer.order(ByteOrder.LITTLE_ENDIAN);
                for (ByteBuffer byteBuffer2 : byteBufferArr) {
                    byteBuffer2.order(ByteOrder.LITTLE_ENDIAN);
                }
                AccessibilityBridge.this.updateSemantics(byteBuffer, strArr, byteBufferArr);
            }
        };
        AccessibilityManager.AccessibilityStateChangeListener accessibilityStateChangeListener = new AccessibilityManager.AccessibilityStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.2
            @Override // android.view.accessibility.AccessibilityManager.AccessibilityStateChangeListener
            public void onAccessibilityStateChanged(boolean z7) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                AccessibilityBridge accessibilityBridge = AccessibilityBridge.this;
                if (z7) {
                    accessibilityBridge.accessibilityChannel.setAccessibilityMessageHandler(AccessibilityBridge.this.accessibilityMessageHandler);
                    AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityEnabled();
                } else {
                    accessibilityBridge.setAccessibleNavigation(false);
                    AccessibilityBridge.this.accessibilityChannel.setAccessibilityMessageHandler(null);
                    AccessibilityBridge.this.accessibilityChannel.onAndroidAccessibilityDisabled();
                }
                if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                    AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(z7, AccessibilityBridge.this.accessibilityManager.isTouchExplorationEnabled());
                }
            }
        };
        this.accessibilityStateChangeListener = accessibilityStateChangeListener;
        ContentObserver contentObserver = new ContentObserver(new Handler()) { // from class: io.flutter.view.AccessibilityBridge.3
            @Override // android.database.ContentObserver
            public void onChange(boolean z7) {
                onChange(z7, null);
            }

            @Override // android.database.ContentObserver
            public void onChange(boolean z7, Uri uri) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                if (Settings.Global.getFloat(AccessibilityBridge.this.contentResolver, "transition_animation_scale", AccessibilityBridge.DEFAULT_TRANSITION_ANIMATION_SCALE) == AccessibilityBridge.DISABLED_TRANSITION_ANIMATION_SCALE) {
                    AccessibilityBridge.access$1176(AccessibilityBridge.this, AccessibilityFeature.DISABLE_ANIMATIONS.value);
                } else {
                    AccessibilityBridge.access$1172(AccessibilityBridge.this, ~AccessibilityFeature.DISABLE_ANIMATIONS.value);
                }
                AccessibilityBridge.this.sendLatestAccessibilityFlagsToFlutter();
            }
        };
        this.animationScaleObserver = contentObserver;
        this.rootAccessibilityView = view;
        this.accessibilityChannel = accessibilityChannel;
        this.accessibilityManager = accessibilityManager;
        this.contentResolver = contentResolver;
        this.accessibilityViewEmbedder = accessibilityViewEmbedder;
        this.platformViewsAccessibilityDelegate = platformViewsAccessibilityDelegate;
        accessibilityStateChangeListener.onAccessibilityStateChanged(accessibilityManager.isEnabled());
        accessibilityManager.addAccessibilityStateChangeListener(accessibilityStateChangeListener);
        AccessibilityManager.TouchExplorationStateChangeListener touchExplorationStateChangeListener = new AccessibilityManager.TouchExplorationStateChangeListener() { // from class: io.flutter.view.AccessibilityBridge.4
            @Override // android.view.accessibility.AccessibilityManager.TouchExplorationStateChangeListener
            public void onTouchExplorationStateChanged(boolean z7) {
                if (AccessibilityBridge.this.isReleased) {
                    return;
                }
                if (!z7) {
                    AccessibilityBridge.this.setAccessibleNavigation(false);
                    AccessibilityBridge.this.onTouchExplorationExit();
                }
                if (AccessibilityBridge.this.onAccessibilityChangeListener != null) {
                    AccessibilityBridge.this.onAccessibilityChangeListener.onAccessibilityChanged(accessibilityManager.isEnabled(), z7);
                }
            }
        };
        this.touchExplorationStateChangeListener = touchExplorationStateChangeListener;
        touchExplorationStateChangeListener.onTouchExplorationStateChanged(accessibilityManager.isTouchExplorationEnabled());
        accessibilityManager.addTouchExplorationStateChangeListener(touchExplorationStateChangeListener);
        contentObserver.onChange(false);
        contentResolver.registerContentObserver(Settings.Global.getUriFor("transition_animation_scale"), false, contentObserver);
        if (Build.VERSION.SDK_INT >= 31) {
            setBoldTextFlag();
        }
        platformViewsAccessibilityDelegate.attachAccessibilityBridge(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AccessibilityEvent obtainAccessibilityEvent(int i8, int i9) {
        AccessibilityEvent accessibilityEventObtainAccessibilityEvent = obtainAccessibilityEvent(i9);
        accessibilityEventObtainAccessibilityEvent.setPackageName(this.rootAccessibilityView.getContext().getPackageName());
        accessibilityEventObtainAccessibilityEvent.setSource(this.rootAccessibilityView, i8);
        return accessibilityEventObtainAccessibilityEvent;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sendAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (this.accessibilityManager.isEnabled()) {
            this.rootAccessibilityView.getParent().requestSendAccessibilityEvent(this.rootAccessibilityView, accessibilityEvent);
        }
    }

    public AccessibilityNodeInfo obtainAccessibilityNodeInfo(View view, int i8) {
        return AccessibilityNodeInfo.obtain(view, i8);
    }

    public boolean onAccessibilityHoverEvent(MotionEvent motionEvent, boolean z7) {
        if (!this.accessibilityManager.isTouchExplorationEnabled() || this.flutterSemanticsTree.isEmpty()) {
            return false;
        }
        SemanticsNode semanticsNodeHitTest = getRootSemanticsNode().hitTest(new float[]{motionEvent.getX(), motionEvent.getY(), DISABLED_TRANSITION_ANIMATION_SCALE, DEFAULT_TRANSITION_ANIMATION_SCALE}, z7);
        if (semanticsNodeHitTest != null && semanticsNodeHitTest.platformViewId != -1) {
            if (z7) {
                return false;
            }
            return this.accessibilityViewEmbedder.onAccessibilityHoverEvent(semanticsNodeHitTest.id, motionEvent);
        }
        if (motionEvent.getAction() == 9 || motionEvent.getAction() == 7) {
            handleTouchExploration(motionEvent.getX(), motionEvent.getY(), z7);
        } else {
            if (motionEvent.getAction() != 10) {
                Log.d("flutter", "unexpected accessibility hover event: " + motionEvent);
                return false;
            }
            onTouchExplorationExit();
        }
        return true;
    }
}
