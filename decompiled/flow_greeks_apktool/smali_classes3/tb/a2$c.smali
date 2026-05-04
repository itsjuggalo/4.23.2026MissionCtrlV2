.class public final Ltb/a2$c;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Ltb/a2;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "c"
.end annotation


# instance fields
.field public final synthetic a:Ltb/a2;


# direct methods
.method public constructor <init>(Ltb/a2;)V
    .locals 0

    .line 1
    iput-object p1, p0, Ltb/a2$c;->a:Ltb/a2;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Ltb/a2;Ltb/a2$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Ltb/a2$c;-><init>(Ltb/a2;)V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .line 1
    iget-object v0, p0, Ltb/a2$c;->a:Ltb/a2;

    .line 2
    .line 3
    invoke-static {v0}, Ltb/a2;->a(Ltb/a2;)Ljava/util/concurrent/Executor;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    new-instance v1, Ltb/a2$b;

    .line 8
    .line 9
    iget-object v2, p0, Ltb/a2$c;->a:Ltb/a2;

    .line 10
    .line 11
    const/4 v3, 0x0

    .line 12
    invoke-direct {v1, v2, v3}, Ltb/a2$b;-><init>(Ltb/a2;Ltb/a2$a;)V

    .line 13
    .line 14
    .line 15
    invoke-interface {v0, v1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    .line 16
    .line 17
    .line 18
    return-void
    .line 19
.end method
