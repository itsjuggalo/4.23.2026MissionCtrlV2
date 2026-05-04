.class public Ltb/m$a$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ltb/n1$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/m$a;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = null
.end annotation


# instance fields
.field public final synthetic a:Ltb/m$a;


# direct methods
.method public constructor <init>(Ltb/m$a;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/m$a$a;->a:Ltb/m$a;

    .line 2
    .line 3
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

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
    .line 20
    .line 21
    .line 22
    .line 23
    .line 24
    .line 25
    .line 26
.end method


# virtual methods
.method public onComplete()V
    .locals 1

    .line 1
    iget-object v0, p0, Ltb/m$a$a;->a:Ltb/m$a;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/m$a;->e(Ltb/m$a;)Ljava/util/concurrent/atomic/AtomicInteger;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->decrementAndGet()I

    .line 8
    .line 9
    .line 10
    move-result v0

    .line 11
    if-nez v0, :cond_0

    .line 12
    .line 13
    iget-object v0, p0, Ltb/m$a$a;->a:Ltb/m$a;

    .line 14
    .line 15
    invoke-static {v0}, Ltb/m$a;->i(Ltb/m$a;)V

    .line 16
    .line 17
    .line 18
    :cond_0
    return-void
    .line 19
.end method
