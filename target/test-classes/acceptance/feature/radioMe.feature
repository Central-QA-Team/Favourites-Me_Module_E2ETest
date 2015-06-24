
Feature: Radio Me Module


Scenario Outline: Tab label is capitalized for "Programme Updates"
  Given I am on Radio me module
  And I signed in from benefits page as a normal user
  Then Title of the "<tab>" should be "<text>"
Examples:
    |tab|text|
    |first_tab|Programme Updates|
    |second_tab|Episodes & Clips|


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


Scenario Outline: Tab description
   Given I am on Radio me module
   And I signed in from benefits page as a normal user
   And I click on the "<tab>" tab
   Then description text "<description>" should be displayed at the top
 Examples:
  | tab     | description                    |
  | Programme Updates  | Newly available episodes (most recent first) of the last 100 programmes you added to your favourites. Removing an item means you’ll stop getting new episodes of that programme here.|
  | Episodes & Clips  | Clips and individual episodes you’ve added to your Favourites. Any newly available episodes of these programmes will appear in Programme Updates.      |


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


  Scenario: Favourite page title
    Given I am on Radio me module
    And Page should have title "Favourites"


  Scenario Outline: Favourite page title
    Given I am on Radio me module
    And I change page language to "<lang>"
    And Page should have title "<title>"
  Examples:
    | lang     | title   |
    | Cymraeg  | Ffefrynnau |
    | Gaeilge  | Ceanáin    |
    | Gàidhlig | Roghainnean|


  Scenario: Benefits page
    Given I am on Radio me module
    Then Benefits page should have "Save stuff for later.,Get the latest updates.,All on any device."
    And Benefits page should have ID CTA

@web
  Scenario Outline: Benefits page
    Given I am on Radio me module
    And I change page language to "<lang>"
    Then Benefits page should have "<benefits>"
    And Benefits page should have ID CTA
  Examples:
  | lang     | benefits                    |
  | Cymraeg  | Arbed cynnwys tan wedyn.,Derbyn diweddariadau.,Popeth mewn unrhyw ddyfais.|
  | Gaeilge  | Sábháil ábhar anois agus pill air níos moille.,Faigh na nuashonruithe is déanaí.,Ar fáil ar gach gléas.|
  | Gàidhlig | Sàbhail do stuth airson àm eile.,Am fiosrachadh as ùire.,Air inneal sam bith.|


  Scenario: Empty page
    Given I am on Radio me module
    And I signed in from benefits page as a new user
    Then Empty page should have first line "There are no programmes in your Favourites right now."
    And Empty page should have second line "Add programmes to get updates when new episodes become available"
    And Empty page should have desired image on it


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


