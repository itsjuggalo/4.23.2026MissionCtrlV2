.class public final Landroidx/activity/p$i;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"

# interfaces
.implements Landroidx/activity/c;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/activity/p;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "i"
.end annotation


# instance fields
.field public final a:Landroidx/activity/o;

.field public final synthetic b:Landroidx/activity/p;


# direct methods
.method public constructor <init>(Landroidx/activity/p;Landroidx/activity/o;)V
    .locals 1

    .line 1
    const-string v0, "onBackPressedCallback"

    .line 2
    .line 3
    invoke-static {p2, v0}, Lkotlin/jvm/internal/t;->f(Ljava/lang/Object;Ljava/lang/String;)V

    .line 4
    .line 5
    .line 6
    iput-object p1, p0, Landroidx/activity/p$i;->b:Landroidx/activity/p;

    .line 7
    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    .line 10
    .line 11
    iput-object p2, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 12
    .line 13
    return-void
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
    .line 27
    .line 28
    .line 29
    .line 30
    .line 31
    .line 32
    .line 33
    .line 34
    .line 35
    .line 36
    .line 37
    .line 38
    .line 39
.end method


# virtual methods
.method public cancel()V
    .locals 2

    .line 1
    iget-object v0, p0, Landroidx/activity/p$i;->b:Landroidx/activity/p;

    .line 2
    .line 3
    invoke-static {v0}, Landroidx/activity/p;->b(Landroidx/activity/p;)Ldd/i;

    .line 4
    .line 5
    .line 6
    move-result-object v0

    .line 7
    iget-object v1, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 8
    .line 9
    invoke-virtual {v0, v1}, Ldd/i;->remove(Ljava/lang/Object;)Z

    .line 10
    .line 11
    .line 12
    iget-object v0, p0, Landroidx/activity/p$i;->b:Landroidx/activity/p;

    .line 13
    .line 14
    invoke-static {v0}, Landroidx/activity/p;->a(Landroidx/activity/p;)Landroidx/activity/o;

    .line 15
    .line 16
    .line 17
    move-result-object v0

    .line 18
    iget-object v1, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 19
    .line 20
    invoke-static {v0, v1}, Lkotlin/jvm/internal/t;->b(Ljava/lang/Object;Ljava/lang/Object;)Z

    .line 21
    .line 22
    .line 23
    move-result v0

    .line 24
    const/4 v1, 0x0

    .line 25
    if-eqz v0, :cond_0

    .line 26
    .line 27
    iget-object v0, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 28
    .line 29
    invoke-virtual {v0}, Landroidx/activity/o;->handleOnBackCancelled()V

    .line 30
    .line 31
    .line 32
    iget-object v0, p0, Landroidx/activity/p$i;->b:Landroidx/activity/p;

    .line 33
    .line 34
    invoke-static {v0, v1}, Landroidx/activity/p;->f(Landroidx/activity/p;Landroidx/activity/o;)V

    .line 35
    .line 36
    .line 37
    :cond_0
    iget-object v0, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 38
    .line 39
    invoke-virtual {v0, p0}, Landroidx/activity/o;->removeCancellable(Landroidx/activity/c;)V

    .line 40
    .line 41
    .line 42
    iget-object v0, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 43
    .line 44
    invoke-virtual {v0}, Landroidx/activity/o;->getEnabledChangedCallback$activity_release()Lkotlin/jvm/functions/Function0;

    .line 45
    .line 46
    .line 47
    move-result-object v0

    .line 48
    if-eqz v0, :cond_1

    .line 49
    .line 50
    invoke-interface {v0}, Lkotlin/jvm/functions/Function0;->invoke()Ljava/lang/Object;

    .line 51
    .line 52
    .line 53
    :cond_1
    iget-object v0, p0, Landroidx/activity/p$i;->a:Landroidx/activity/o;

    .line 54
    .line 55
    invoke-virtual {v0, v1}, Landroidx/activity/o;->setEnabledChangedCallback$activity_release(Lkotlin/jvm/functions/Function0;)V

    .line 56
    .line 57
    .line 58
    return-void
    .line 59
    .line 60
    .line 61
.end method
