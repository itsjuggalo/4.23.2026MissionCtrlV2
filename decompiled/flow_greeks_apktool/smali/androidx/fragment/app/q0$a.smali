.class public final Landroidx/fragment/app/q0$a;
.super Ljava/lang/Object;
.source "r8-map-id-f7c0ba7912e30bee969b60fc55dfe505a38d9b7b2320734346e2a4068d44c6f7"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Landroidx/fragment/app/q0;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "a"
.end annotation


# instance fields
.field public a:I

.field public b:Landroidx/fragment/app/p;

.field public c:Z

.field public d:I

.field public e:I

.field public f:I

.field public g:I

.field public h:Landroidx/lifecycle/i$b;

.field public i:Landroidx/lifecycle/i$b;


# direct methods
.method public constructor <init>()V
    .locals 0

    .line 1
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public constructor <init>(ILandroidx/fragment/app/p;)V
    .locals 0

    .line 2
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 3
    iput p1, p0, Landroidx/fragment/app/q0$a;->a:I

    .line 4
    iput-object p2, p0, Landroidx/fragment/app/q0$a;->b:Landroidx/fragment/app/p;

    const/4 p1, 0x0

    .line 5
    iput-boolean p1, p0, Landroidx/fragment/app/q0$a;->c:Z

    .line 6
    sget-object p1, Landroidx/lifecycle/i$b;->e:Landroidx/lifecycle/i$b;

    iput-object p1, p0, Landroidx/fragment/app/q0$a;->h:Landroidx/lifecycle/i$b;

    .line 7
    iput-object p1, p0, Landroidx/fragment/app/q0$a;->i:Landroidx/lifecycle/i$b;

    return-void
.end method

.method public constructor <init>(ILandroidx/fragment/app/p;Z)V
    .locals 0

    .line 8
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 9
    iput p1, p0, Landroidx/fragment/app/q0$a;->a:I

    .line 10
    iput-object p2, p0, Landroidx/fragment/app/q0$a;->b:Landroidx/fragment/app/p;

    .line 11
    iput-boolean p3, p0, Landroidx/fragment/app/q0$a;->c:Z

    .line 12
    sget-object p1, Landroidx/lifecycle/i$b;->e:Landroidx/lifecycle/i$b;

    iput-object p1, p0, Landroidx/fragment/app/q0$a;->h:Landroidx/lifecycle/i$b;

    .line 13
    iput-object p1, p0, Landroidx/fragment/app/q0$a;->i:Landroidx/lifecycle/i$b;

    return-void
.end method
