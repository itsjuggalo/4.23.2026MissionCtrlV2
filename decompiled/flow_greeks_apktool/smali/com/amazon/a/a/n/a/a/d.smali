.class public Lcom/amazon/a/a/n/a/a/d;
.super Lcom/amazon/a/a/d/b;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# static fields
.field private static final a:J = 0x1L


# direct methods
.method public constructor <init>(Landroid/os/RemoteException;)V
    .locals 0

    .line 1
    invoke-static {p1}, Lcom/amazon/a/a/n/a/a/d;->a(Landroid/os/RemoteException;)Ljava/lang/String;

    .line 2
    .line 3
    .line 4
    move-result-object p1

    .line 5
    invoke-direct {p0, p1}, Lcom/amazon/a/a/d/b;-><init>(Ljava/lang/String;)V

    .line 6
    .line 7
    .line 8
    return-void
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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method

.method private static a(Landroid/os/RemoteException;)Ljava/lang/String;
    .locals 0

    .line 1
    instance-of p0, p0, Landroid/os/DeadObjectException;

    .line 2
    .line 3
    if-eqz p0, :cond_0

    .line 4
    .line 5
    const-string p0, "COMMAND_SERVICE_DEAD_OBJECT_EXCEPTION"

    .line 6
    .line 7
    return-object p0

    .line 8
    :cond_0
    const-string p0, "COMMAND_SERVICE_REMOTE_EXCEPTION"

    .line 9
    .line 10
    return-object p0
    .line 11
    .line 12
    .line 13
    .line 14
    .line 15
    .line 16
    .line 17
    .line 18
    .line 19
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
.end method
