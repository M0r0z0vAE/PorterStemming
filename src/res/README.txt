АЛГОРИТМ 
Согласная в слове — это буква, отличная от A, E, I, O или U, и отличная от Y буква, которой предшествует согласная. 
Таким образом, в слове TOY согласные — T и Y, а в слове SYZYGY — S, Z и G. Если буква не согласная, а гласная.

consonant (C) - согласная 
vowel (V) - гласная

Согласная будет обозначаться буквой c, гласная буквой v. Список ccc... длины больше 0 будет обозначаться буквой C, 
а список vvv... длины больше 0 будет обозначаться буквой V. Любое слово , или часть слова, поэтому имеет одну из четырех форм:

CVCV ... C
CVCV ... V
VCVC ... C
VCVC ... V

[C](VC)^m[V]

m будем называть мерой любого слова или части слова, представленного в этой форме. 
Случай m = 0 покрывает нулевое слово. Вот некоторые примеры:

m=0		TR,   EE,   TREE,   Y,   BY.
m=1		TROUBLE,   OATS,   TREES,   IVY.
m=2		TROUBLES,   PRIVATE,   OATEN,   ORRERY.

Условия:
Часть «условие» может также содержать следующее:
*S - основа оканчивается на S (и аналогично для остальных букв).
*v* - основа содержит гласную.
*d - основа оканчивается двойным согласным (например, -ТТ, -СС).
*o - основа заканчивается cvc, где второе c не равно W, X или Y (например, -WIL, -HOP).

Алгоритм следующий:

----------------------------------------------------------------------------------------------------------------------------------------------------------
Step 1a

SSES	->	SS	caresses	->	caress
IES	->	I	ponies		->	poni
    			ties		->	ti
SS	->	SS	caress		->	caress
S	->		cats		->	cat

Step 1b
(m>0) EED	->	EE	feed		->	feed
    				agreed		->	agree
(*v*) ED	->		plastered	->	plaster
    				bled		->	bled
(*v*) ING	->		motoring	->	motor
				sing		->	sing

Если второе или третье правило шага 1b выполняется успешно, выполняется следующее:

AT				->	ATE		conflat(ed)	->	conflate
BL				->	BLE		troubl(ed)	->	trouble
IZ				->	IZE		siz(ed)		->	size
(*d and not (*L or *S or *Z))	->	single letter	hopp(ing)	->	hop
    							tann(ed)	->	tan
    							fall(ing)	->	fall
    							hiss(ing)	->	hiss
    							fizz(ed)	->	fizz
(m=1 and *o)			->	E		fail(ing)	->	fail
    							fil(ing)	->	file

Правило сопоставления с одной буквой приводит к удалению одной из пар двойных букв. -E ставится обратно на -AT, -BL и -IZ, чтобы суффиксы -ATE, 
-BLE и -IZE можно было распознать позже. Этот E может быть удален на шаге 4.

Step 1c
(*v*) Y		->	I happy	->	happi
    			sky	->	sky

Шаг 1 касается множественного числа и причастий прошедшего времени. Последующие шаги намного проще.

----------------------------------------------------------------------------------------------------------------------------------------------------------
Step 2

(m>0) ATIONAL		->		ATE		    		relational		->		relate
(m>0) TIONAL		->		TION		    		conditional		->		condition
    									rational		->		rational
(m>0) ENCI		->		ENCE		    		valenci			->		valence
(m>0) ANCI		->		ANCE		    		hesitanci		->		hesitance
(m>0) IZER		->		IZE		    		digitizer		->		digitize
(m>0) ABLI		->		ABLE		    		conformabli		->		conformable
(m>0) ALLI		->		AL		    		radicalli		->		radical
(m>0) ENTLI		->		ENT		    		differentli		->		different
(m>0) ELI		->		E		    		vileli			->		vile
(m>0) OUSLI		->		OUS		    		analogousli		->		analogous
(m>0) IZATION		->		IZE		    		vietnamization		->		vietnamize
(m>0) ATION		->		ATE		    		predication		->		predicate
(m>0) ATOR		->		ATE		    		operator		->		operate
(m>0) ALISM		->		AL		    		feudalism		->		feudal
(m>0) IVENESS		->		IVE		    		decisiveness		->		decisive
(m>0) FULNESS		->		FUL		    		hopefulness		->		hopeful
(m>0) OUSNESS		->		OUS		    		callousness		->		callous
(m>0) ALITI		->		AL		    		formaliti		->		formal
(m>0) IVITI		->		IVE		    		sensitiviti		->		sensitive
(m>0) BILITI		->		BLE		    		sensibiliti		->		sensible

----------------------------------------------------------------------------------------------------------------------------------------------------------
Step 3

(m>0) ICATE		->		IC		    		triplicate		->		triplic
(m>0) ATIVE		->				    		formative		->		form
(m>0) ALIZE		->		AL		    		formalize		->		formal
(m>0) ICITI		->		IC		    		electriciti		->		electric
(m>0) ICAL		->		IC		    		electrical		->		electric
(m>0) FUL		->				    		hopeful			->		hope
(m>0) NESS		->				    		goodness		->		good

----------------------------------------------------------------------------------------------------------------------------------------------------------
Step 4

(m>1) AL		->				    		revival			->		reviv
(m>1) ANCE		->				    		allowance		->		allow
(m>1) ENCE		->				    		inference		->		infer
(m>1) ER		->				    		airliner		->		airlin
(m>1) IC		->				    		gyroscopic		->		gyroscop
(m>1) ABLE		->				    		adjustable		->		adjust
(m>1) IBLE		->				    		defensible		->		defens
(m>1) ANT		->				    		irritant		->		irrit
(m>1) EMENT		->				    		replacement		->		replac
(m>1) MENT		->				    		adjustment		->		adjust
(m>1) ENT		->				    		dependent		->		depend
(m>1 and (*S or *T)) ION->				    		adoption		->		adopt
(m>1) OU		->				    		homologou		->		homolog
(m>1) ISM		->				    		communism		->		commun
(m>1) ATE		->				    		activate		->		activ
(m>1) ITI		->				    		angulariti		->		angular
(m>1) OUS		->				    		homologous		->		homolog
(m>1) IVE		->				    		effective		->		effect
(m>1) IZE		->				    		bowdlerize		->		bowdler

Суффиксы теперь удалены.

----------------------------------------------------------------------------------------------------------------------------------------------------------
Step 5a

(m>1) E			->		probate		->		probat
    					rate		->		rate
(m=1 and not *o) E	->		cease		->		ceas

Step 5b
(m > 1 and *d and *L)	->	single letter	controll	->	control
    						roll		->	roll

----------------------------------------------------------------------------------------------------------------------------------------------------------
// consonant() - b[i] - согласная.
// m() - измеряет количество последовательностей согласных от 0 до j.
// vowelTrue() истинно <=> 0,...j содержит гласную [для 1b и 1c].
// doubleC(j) истинно <=> j,(j-1) содержат двойную согласную.
// cvc(i) верно <=> i-2,i-1,i имеет вид согласная - гласная - согласная.
// setW - задает (j+1),...k символы строки s, перенастраивая к.