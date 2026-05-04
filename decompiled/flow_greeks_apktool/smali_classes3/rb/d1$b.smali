.class public final Lrb/d1$b;
.super Lrb/b1$c;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lrb/d1;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x11
    name = "b"
.end annotation


# instance fields
.field public final synthetic a:Lrb/d1;


# direct methods
.method public constructor <init>(Lrb/d1;)V
    .locals 0

    .line 1
    iput-object p1, p0, Lrb/d1$b;->a:Lrb/d1;

    invoke-direct {p0}, Lrb/b1$c;-><init>()V

    return-void
.end method

.method public synthetic constructor <init>(Lrb/d1;Lrb/d1$a;)V
    .locals 0

    .line 2
    invoke-direct {p0, p1}, Lrb/d1$b;-><init>(Lrb/d1;)V

    return-void
.end method
