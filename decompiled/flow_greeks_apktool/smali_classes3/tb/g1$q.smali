.class public final Ltb/g1$q;
.super Ltb/w0;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/g1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "q"
.end annotation


# instance fields
.field public final synthetic b:Ltb/g1;


# direct methods
.method public constructor <init>(Ltb/g1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/g1$q;->b:Ltb/g1;

    invoke-direct {p0}, Ltb/w0;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ltb/g1;Ltb/g1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Ltb/g1$q;-><init>(Ltb/g1;)V

    return-void
.end method


# virtual methods
.method public b()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$q;->b:Ltb/g1;

    .line 2
    .line 3
    invoke-virtual {v0}, Ltb/g1;->z0()V

    .line 4
    .line 5
    .line 6
    return-void
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

.method public c()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/g1$q;->b:Ltb/g1;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/g1;->q(Ltb/g1;)Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-eqz v0, :cond_0

    .line 12
    .line 13
    return-void

    .line 14
    :cond_0
    iget-object v0, p0, Ltb/g1$q;->b:Ltb/g1;

    .line 15
    .line 16
    invoke-static {v0}, Ltb/g1;->v0(Ltb/g1;)V

    .line 17
    .line 18
    .line 19
    return-void
.end method
