.class public final Lce/g;
.super Lce/i;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lce/g$a;
    }
.end annotation


# static fields
.field public static final h:Lce/g$a;

.field public static final i:Lcd/k;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .line 1
    new-instance v0, Lce/g$a;

    .line 2
    .line 3
    const/4 v1, 0x0

    .line 4
    invoke-direct {v0, v1}, Lce/g$a;-><init>(Lkotlin/jvm/internal/k;)V

    .line 5
    .line 6
    .line 7
    sput-object v0, Lce/g;->h:Lce/g$a;

    .line 8
    .line 9
    sget-object v0, Lce/f;->a:Lce/f;

    .line 10
    .line 11
    invoke-static {v0}, Lcd/l;->b(Lkotlin/jvm/functions/Function0;)Lcd/k;

    .line 12
    .line 13
    .line 14
    move-result-object v0

    .line 15
    sput-object v0, Lce/g;->i:Lcd/k;

    .line 16
    .line 17
    return-void
    .line 18
    .line 19
.end method

.method public constructor <init>(Z)V
    .locals 2

    .line 1
    new-instance v0, Lwf/f;

    const-string v1, "DefaultBuiltIns"

    invoke-direct {v0, v1}, Lwf/f;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lce/i;-><init>(Lwf/n;)V

    if-eqz p1, :cond_0

    const/4 p1, 0x0

    .line 2
    invoke-virtual {p0, p1}, Lce/i;->f(Z)V

    :cond_0
    return-void
.end method

.method public synthetic constructor <init>(ZILkotlin/jvm/internal/k;)V
    .locals 0

    const/4 p3, 0x1

    and-int/2addr p2, p3

    if-eqz p2, :cond_0

    move p1, p3

    .line 3
    :cond_0
    invoke-direct {p0, p1}, Lce/g;-><init>(Z)V

    return-void
.end method

.method public static final G0()Lce/g;
    .locals 4

    .line 1
    new-instance v0, Lce/g;

    .line 2
    .line 3
    const/4 v1, 0x1

    .line 4
    const/4 v2, 0x0

    .line 5
    const/4 v3, 0x0

    .line 6
    invoke-direct {v0, v3, v1, v2}, Lce/g;-><init>(ZILkotlin/jvm/internal/k;)V

    .line 7
    .line 8
    .line 9
    return-object v0
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public static final synthetic H0()Lcd/k;
    .locals 1

    .line 1
    sget-object v0, Lce/g;->i:Lcd/k;

    .line 2
    .line 3
    return-object v0
    .line 4
    .line 5
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method

.method public static synthetic I0()Lce/g;
    .locals 1

    .line 1
    invoke-static {}, Lce/g;->G0()Lce/g;

    .line 2
    .line 3
    .line 4
    move-result-object v0

    .line 5
    return-object v0
    .line 6
    .line 7
    .line 8
    .line 9
    .line 10
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
.end method
