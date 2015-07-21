
Feature: Radio Me Module

  @automated
Scenario Outline: Tab label is capitalized for "Programme Updates"
  Given I am on Radio me module
  And I signed in from benefits page as a normal user
  Then Title of the "<tab>" should be "<text>"
Examples:
    |tab|text|
    |first_tab|Programme Updates|
    |second_tab|Episodes & Clips|

  @automated
Scenario Outline: Translations for "Programme Updates"
  Given I am on Radio me module
  And I signed in from benefits page as a normal user
  And I change page language to "<lang>"
  Then Title of the "first_tab" should be "<title>"

Examples:
  | lang     | title                    |
  | Cymraeg  | Y Diweddaraf am Raglenni |
  | Gaeilge  | Cláir nuashonraithe      |
  | Gàidhlig | Ùrachaidhean Prògram     |

  @automated
  Scenario Outline: Translations for "Episodes & Clips"
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I change page language to "<lang>"
    Then Title of the "second_tab" should be "<title>"

  Examples:
    | lang     | title                    |
    | Cymraeg  | Clipiau a Phenodau       |
    | Gaeilge  | Gearrthóga & Eagráin     |
    | Gàidhlig | Criomagan & Prògraman    |

  @automated
Scenario Outline: Tab description
   Given I am on Radio me module
   And I signed in from benefits page as a normal user
   And I click on the "<tab>" tab
   Then description text "<description>" should be displayed at the top
 Examples:
  | tab     | description                    |
  | Programme Updates  | Newly available episodes (most recent first) of the last 100 programmes you added to your favourites. Removing an item means you’ll stop getting new episodes of that programme here.|
  | Episodes & Clips  | Clips and individual episodes you’ve added to your Favourites. Any newly available episodes of these programmes will appear in Programme Updates.      |

  @automated
  Scenario Outline: Translations of Tab description for "Programme Updates"
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I change page language to "<lang>"
    And I click on the "Programme Updates" tab
    Then description text "<description>" should be displayed at the top
  Examples:
    | lang     | description                    |
    | Cymraeg  | Penodau newydd (y diweddaraf gyntaf) o'r 100 o raglenni diwethaf gafodd eu hychwanegu i'ch ffefrynnau. Bydd cael gwared ag eitem yn golygu na fydd penodau newydd o’r rhaglen yn ymddangos yma mwyach.      |
    | Gaeilge  | Eagráin nua-fhaighte (is úire ar dtús) den 100 clár is déanaí a chuir tú le do cheanáin. Má bhaineann tú mír ar shiúl, is ionann sin is nach bhfaighidh tú eagráin úra den chlár sin anseo.    |
    | Gàidhlig | Prògraman ùra (as ùire an toiseach) bhon 100 prògram mu dheireadh a chur thu rid roghainnean. Le bhith dubhadh às prògram, cha nochd an còrr an seo.    |

  @automated
  Scenario Outline: Translations of Tab description for "Episodes & Clips"
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I change page language to "<lang>"
    And I click on the "Episodes & Clips" tab
    Then description text "<description>" should be displayed at the top
  Examples:
    | lang     | description                    |
    | Cymraeg  | Clipiau a phenodau unigol sydd wedi eu hychwanegu i'ch Ffefrynnau. Bydd penodau newydd o'r rhaglenni yma yn ymddangos yn Y Diweddaraf am Raglenni. |
    | Gaeilge  | Gearrthóga agus eagráin aonaracha atá curtha agat le do Cheanáin. Léireofar aon eagráin nua-fhaighte de na cláir seo in Nuashonraithe Clár. |
    | Gàidhlig | Criomagan agus prògraman a tha thu air a chur ri do Roghainnean. Nochdaidh na prògraman ùra ann an Ùrachaidhean Prògram. |

  @automated
  Scenario: Favourite page title
    Given I am on Radio me module
    And Page should have title "Favourites"

  @automated
  Scenario Outline: Favourite page title
    Given I am on Radio me module
    And I change page language to "<lang>"
    And Page should have title "<title>"
  Examples:
    | lang     | title   |
    | Cymraeg  | Ffefrynnau |
    | Gaeilge  | Ceanáin    |
    | Gàidhlig | Roghainnean|

  @automated
  Scenario: Benefits page
    Given I am on Radio me module
    Then Benefits page should have "Save stuff for later.,Get the latest updates.,All on any device."
    And Benefits page should have ID CTA with text "Sign inwith your BBC iD,or Register to Add to Your Favourites"

  @automated
  Scenario Outline: Benefits page
    Given I am on Radio me module
    And I change page language to "<lang>"
    Then Benefits page should have "<benefits>"
    And Benefits page should have ID CTA with text "<message>"
  Examples:
  | lang     | benefits                    |message |
  | Cymraeg  | Arbed cynnwys tan wedyn.,Derbyn diweddariadau.,Popeth mewn unrhyw ddyfais.|Mewngofnodigyda'ch BBC iD,neu Gofrestru i Add to Your Favourites|
  | Gaeilge  | Sábháil ábhar anois agus pill air níos moille.,Faigh na nuashonruithe is déanaí.,Ar fáil ar gach gléas.|Sínigh isteachle do BBC iD,nó Cláraigh le Add to Your Favourites|
  | Gàidhlig | Sàbhail do stuth airson àm eile.,Am fiosrachadh as ùire.,Air inneal sam bith.| Log a-steachleis am BBC iD agad,no Clàraich airson Add to Your Favourites|

  @automated
  Scenario: Empty page
    Given I am on Radio me module
    And I signed in from benefits page as a new user
    Then Empty page should have first line "There are no programmes in your Favourites right now."
    And Empty page should have second line "Add programmes to get updates when new episodes become available"
    And Empty page should have desired image on it

  @automated
  Scenario Outline: Empty page translations
    Given I am on Radio me module
    And I signed in from benefits page as a new user
    And I change page language to "<lang>"
    Then Empty page should have first line "<first_line>"
    And Empty page should have second line "<second_line>"
    And Empty page should have desired image on it
  Examples:
    |lang|first_line|second_line|
    | Cymraeg  | Does dim rhaglenni yn eich Ffefrynnau ar hyn o bryd. | Rhaid ychwanegu rhaglenni er mwyn cael gwybod pan fydd penodau newydd ar gael |
    | Gaeilge  | Níl cláir ar bith i do Cheanáin faoi láthair. | Cuir cláir leis le nuashonraithe a fháil nuair a bheidh eagráin úra ar fáil |
    | Gàidhlig | Chan eil prògraman nad Roghainnean an-dràsta. | Cuir prògraman ris airson fios mu fheadhainn ùra fhaighinn |

  @automated
  Scenario: Tile navigation for clips and episode
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I click on the "Episodes & Clips" tab
    Then clicking on tile should take user to respective programmes page

  @wip
  Scenario: Tile navigation for programmes Update
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I click on the "Programme Updates" tab
    Then clicking on brand tile should take user to respective page


  @automated
  Scenario Outline: Number of favourites per page
    Given I am on Radio me module
    And I signed in from benefits page as a normal user
    And I click on the "<tab>" tab
    And user should have at max <no_of_items> per page
  Examples:
    |tab|no_of_items|
    |Programme Updates|5|
    |Episodes & Clips |20|


#  @wip
#  Scenario:C431546 Deletion of programme
#    Given I am a signed in user
#    And I navigate to BBC radio home page
#    And I add brand to Favourite
#    And I am on Radio me module
#    And I click on the "Programme Updates" tab
#    When I delete item from action panel
#    Then item should be removed from me module
#    When I go to recipe page
#    And item should be removed from favorite
#
#
#  @wip1
#  Scenario:C172185 Action panel contains 3 dots
#    Given I am a signed in user
#    And I am on Food homepage
#    And I add recipe to Favourite
#    And I am on Radio me module
#    Then action panel will be displayed as 3 vertical dots
#
#
#  @wip1
#  Scenario: C172186
#    Given I am a signed in user
#    And I am on Food homepage
#    And I add recipe to Favourite
#    When I am on Food me module
#    Then action panel should contain "Remove?,Yes,No"

