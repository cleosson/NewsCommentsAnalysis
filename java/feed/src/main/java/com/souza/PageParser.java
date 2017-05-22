package com.souza;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by csouza on 03/05/17.
 */



public class PageParser {

    private String url;

    String test = "         <!--TEXTO--> \n"
            + "         <div class=\"author\" itemprop=\"author\"> \n"
            + "          <p> <b>BELA MEGALE</b><br> <b>CAMILA MATTOSO</b><br> DE BRASÍLIA </p> \n"
            + "         </div> \n" + "         <time datetime=\"2017-05-12 07:56\"> \n"
            + "          <!--DATA-->12/05/2017\n"
            + "          <!--/DATA--> <i class=\"sprite icon-clock\"></i> \n"
            + "          <!--HORA-->07h56\n"
            + "          <!--/HORA--> - Atualizado às 09h41 </time> \n" + "        </header> \n"
            + "        <!--noindex-->\n" + "        <!--PRINT:EXCLUDE--> \n"
            + "        <div class=\"toolbar rs_preserve rs_skip\"> \n"
            + "         <div data-share-buttons=\"facebook twitter googleplus linkedin email\" data-share-buttons-mobile=\"facebook whatsapp twitter googleplus linkedin\" data-share-url=\"http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\" data-share-button-facebook-text=\"Compartilhar\" data-share-twitter-text=\"Operação da PF investiga empréstimos do BNDES à JBS; Palocci é citado\"></div> \n"
            + "         <!-- <div class=\"buttons\"></div> --> \n"
            + "         <div class=\"read-speaker\"></div> \n"
            + "         <div class=\"options\"> \n"
            + "          <a href=\"javascript:;\" class=\"main\"><i class=\"sprite icon-plus\"></i><span>Mais opções</span></a> \n"
            + "          <div class=\"items\"> \n" + "           <i class=\"arrow-up\"></i> \n"
            + "           <ul class=\"unstyled\"> \n"
            + "            <li class=\"facebook\"> <a href=\"http://www.facebook.com/share.php?u=http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\"> <i class=\"section-sprite facebook-small\"></i>Facebook </a> </li> \n"
            + "            <li class=\"whatsapp\"> <script type=\"text/javascript\"><!--\n"
            + "\t\t\t\t\tdocument.write( '<a href=\\\"whatsapp://send?text=Opera%C3%A7%C3%A3o%20da%20PF%20investiga%20empr%C3%A9stimos%20do%20BNDES%20%C3%A0%20JBS%3B%20Palocci%20%C3%A9%20citado http%3A%2F%2Fwww1.folha.uol.com.br%2Fmercado%2F2017%2F05%2F1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml Via Folha de S.Paulo\\\"><i class=\\\"section-sprite icon-whatsapp-small\\\"><\\/i>Whatsapp<\\/a><\\/script>' ) ;\n"
            + "\t\t\t\t\t//--></script> </li> \n"
            + "            <li> <a href=\"http://tools.folha.com.br/send?site=emcimadahora&amp;url=http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\"> <i class=\"section-sprite icon-email\"></i>Enviar por e-mail </a> </li> \n"
            + "            <li class=\"short-cut\"> <a href=\"javascript:;\" class=\"shortcut\" data-shortcut=\"http://folha.com/no1883367\"> <i class=\"section-sprite icon-url\"></i>Copiar url curta </a> </li> \n"
            + "            <li> <a href=\"http://tools.folha.com.br/print?site=emcimadahora&amp;url=http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\"> <i class=\"section-sprite icon-print\"></i>Imprimir </a> </li> \n"
            + "            <li> <a href=\"http://tools.folha.com.br/feedback?url=http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\"> <i class=\"section-sprite icon-warning\"></i>Comunicar erros </a> </li> \n"
            + "            <li class=\"font\"> <i class=\"section-sprite icon-font\"></i><a href=\"javascript:;\" data-size=\"large\">Maior</a> | <a href=\"javascript:;\" data-size=\"small\">Menor</a> </li> \n"
            + "            <li> <a href=\"http://feeds.folha.uol.com.br/mercado/rss091.xml\"> <i class=\"section-sprite icon-rss-small\"></i>RSS </a> </li> \n"
            + "           </ul> \n" + "          </div> \n" + "         </div> \n"
            + "        </div> \n" + "        <script>\n"
            + "folha.toolbar.readspeaker( \"http://tools.folha.com.br/print?url=http://www1.folha.uol.com.br/mercado/2017/05/1883367-pf-deflagra-operacao-que-investiga-fraudes-em-emprestimos-no-bndes.shtml\" ) ;\n"
            + "</script> \n" + "        <!--/PRINT:EXCLUDE-->\n" + "        <!--noindex--> \n"
            + "        <div class=\"content\" itemprop=\"articleBody\"> \n"
            + "         <!--noindex-->\n" + "         <!--PRINT:EXCLUDE--> \n"
            + "         <!-- ad-180x150-1 --> \n"
            + "         <div id=\"ad-180x150-1\" class=\"advertising ad-180x150\"> \n"
            + "          <span class=\"label\">Publicidade</span> \n"
            + "          <div id=\"banner-180x150-1-area\" class=\"tm-ads\"></div> \n"
            + "         </div> \n" + "         <!-- /ad-180x150-1 --> \n"
            + "         <!--/PRINT:EXCLUDE-->\n" + "         <!--/noindex--> \n"
            + "         <p> A Polícia Federal deflagrou nesta sexta (12) a Operação Bullish, que investiga possíveis fraudes e irregularidades em aportes concedidos pelo BNDES (Banco Nacional de Desenvolvimento Econômico e Social). </p> \n"
            + "         <p> Segundo nota da PF, as irregularidades aconteciam por meio da subsidiária BNDESPar e envolviam uma grande empresa do ramo de proteína animal. </p> \n"
            + "         <p> A <b>Folha</b> apurou que se trata da JBS, uma das maiores processadoras de proteína animal do mundo. Ela pertence à J&amp;F, dos irmão Joesley e Wesley Batista. A empresa já é investigada na Greenfield, operação que apura o suposto uso irregular de dinheiro de fundos de pensão. </p> \n"
            + "         <p> Joesley Batista é alvo de condução coercitiva. A medida, porém, não foi cumprida porque ele se encontra no exterior, segundo investigadores. </p> \n"
            + "         <p> \"Os aportes, realizados a partir de junho de 2007, tinham como objetivo a aquisição de empresas também do ramo de frigoríficos no valor total de R$ 8,1 bilhões\", afirma a PF. </p> \n"
            + "         <p> O ex-presidente do BNDES Luciano Coutinho, que está fora do país, também é alvo de condução coercitiva, além de haver um mandado de busca e apreensão na casa dele. </p> \n"
            + "         <table class=\"specialContainer\"> \n" + "          <tbody>\n"
            + "           <tr> \n" + "            <th> <b>DONO DA JBS</b></th> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td> <i>Outros trechos da entrevista com Joesley</i></td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"columnist\"><img src=\"http://f.i.uol.com.br/folha/mercado/images/17045253.jpeg\" alt=\"\" border=\"0\"></td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"link bullet\"><a href=\"http://www1.folha.uol.com.br/mercado/2017/02/1858787-nao-deixarei-o-comando-da-jf-nao-fizemos-nada-de-errado-diz-joesley-batista.shtml\">Joesley diz que não vai deixar comando da JBS e vai provar erro de suspeitas</a> </td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"link bullet\"><a href=\"http://www1.folha.uol.com.br/mercado/2017/02/1858798-viagem-ao-caribe-com-funaro-e-cleto-foi-coincidencia-diz-joesley.shtml\">Viagem ao Caribe com Cleto e Funaro \"foi coincidência\", afirma empresário</a> </td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"link bullet\"><a href=\"http://www1.folha.uol.com.br/mercado/2017/02/1858812-joesley-batista-diz-que-nao-teme-delacoes-premiadas.shtml\">Joesley diz que não teme delações premiadas nem fará uma</a> </td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"link bullet\"><a href=\"http://www1.folha.uol.com.br/mercado/2017/02/1858816-joesley-diz-que-soube-de-corrupcao-pela-tv-e-so-conheceu-lula-em-2013.shtml\">Dono da JBS diz que soube da corrupção no país \"pela TV\" e só conheceu Lula em 2013</a> </td> \n"
            + "           </tr> \n" + "           <tr> \n"
            + "            <td class=\"link bullet\"><a href=\"http://www1.folha.uol.com.br/mercado/2017/02/1858794-nao-financio-mais-politicos-nao-tenho-dinheiro-na-pessoa-fisica-diz-joesley.shtml\">'Não financio mais políticos; não tenho dinheiro na pessoa física', diz Joesley</a> </td> \n"
            + "           </tr> \n" + "          </tbody>\n" + "         </table> \n"
            + "         <p> As investigações apontaram que os desembolsos dos recursos públicos tiveram tramitação em tempo recorde após a empresa contratar a Projeto, consultoria do ex-ministro Antônio Palocci, que está preso em Curitiba no âmbito da Operação Lava Jato. </p> \n"
            + "         <p> Quando a investigação surgiu, em 2014, o procurador Ivan Marx, responsável pelo caso, apurou que a consultora de Palocci estava envolvida na liberação do recurso investigado. </p> \n"
            + "         <p> No entanto, a Projeto passou a ser alvo de outros inquéritos e a operação Bullish focou sua atuação na aquisição de frigoríficos pela JBS. </p> \n"
            + "         <p> Dados obtidos em 2015 pela <b>Folha</b>, indicam que a <a href=\"http://www1.folha.uol.com.br/poder/2015/05/1626973-empresa-de-antonio-palocci-recebeu-r-24-milhoes-em-tres-anos-e-meio.shtml\">JBS foi o quarto maior cliente da consultoria de Palocci até 2010</a>, com pagamentos de R$ 2,285 milhões no total. </p> \n"
            + "         <p> Palocci, que foi ministro dos governos Lula e Dilma, quer negociar acordo de delação premiada e tem o BNDES como um dos temas que pretende explorar. </p> \n"
            + "         <p> A PF relata também que essas transações foram executadas sem a exigência de garantias e geraram um prejuízo de cerca de R$ 1,2 bilhão aos cofres públicos. </p> \n"
            + "         <p> Estão sendo cumpridos 37 mandados de condução coercitiva, sendo 30 no Rio de Janeiro e sete em São Paulo, e 20 de busca e apreensão, sendo 14 no Rio e seis em São Paulo. </p> \n"
            + "         <p> Há também medidas de indisponibilidade de bens de pessoas físicas e jurídicas que participam direta ou indiretamente da composição acionária da empresa investigada. </p> \n"
            + "         <p> Todas as medidas foram autorizadas pelo juiz Ricardo Leite, da Justiça Federal do Distrito Federal. </p> \n"
            + "         <p> Os controladores do grupo ainda estão proibidos de promover alteração societária na empresa e de se ausentar do país sem autorização judicial prévia. </p> \n"
            + "         <p> A PF monitora cinco dos investigados que se encontram em viagem ao exterior. </p> \n"
            + "         <p> O nome Bullish vem da tendência de valorização gerada entre os operadores do mercado financeiro em relação aos papéis da empresa, \"para a qual os aportes da subsidiária BNDESPar foram imprescindíveis\", diz a nota da polícia. </p> \n"
            + "         <p> A reportagem ainda não conseguiu contato com a defesa de todos os citados. </p> \n"
            + "         <p> A J&amp;F informou que ainda não vai se pronunciar, porque as medidas estão em andamento e eles ainda não tiveram acesso a todas as informações de operação. </p> \n"
            + "         <p> <b>TRIBUNAL DE CONTAS</b> </p> \n"
            + "         <p> Em 2015, o <a href=\"http://www1.folha.uol.com.br/mercado/2015/11/1712753-bndes-pode-ter-perdido-r-848-mi-com-frigorifico-jbs-aponta-tcu.shtml\">Tribunal de Contas da União</a> já havia encontrado alguns indícios de que o suporte que o BNDES dava à JBS podia ter lesado o banco estatal em pelo menos R$ 847,7 milhões. </p> \n"
            + "         <p> Entre 2006 e 2014, a JBS recebeu R$ 8,1 bilhões para comprar companhias no exterior e se tornar uma gigante no setor de carnes. Em troca, o banco se tornou sócio da empresa. </p> \n"
            + "        </div> \n" + "        <!--/TEXTO--> \n";

    public PageParser(String url) {
//        this.url = url;
        this.url = "https://esporte.uol.com.br/futebol/ultimas-noticias/2017/05/11/brasil-e-com-sobras-o-pais-que-mais-exporta-atletas-de-futebol-diz-estudo.htm";
    }

    public void readPage() {
        try {
            Document doc = Jsoup.connect(url).get();
            String text = doc.body().text();

            doc = Jsoup.parseBodyFragment(test);
            text = doc.body().text();

        } catch (IOException io) {
            // do something
        }
    }

}

// Página uol
// tem que pegar o id dos comentário
// Config.Comentario={"id":13633379,"product":"","rating":false}
// depois pegar os comentários com a url abaixo
// https://view.comentarios.uol.com.br/ws/v1/subject/retrieve/13633379?portal=uol&callback=BabelModelCommentsSubject
// BabelModelCommentsSubject({"code":"200","result":{"id":"13633379","name":"Brasil é com sobras o país que mais exporta atletas de futebol, diz estudo","description":"Brasil é com sobras o país que mais exporta atletas de futebol, diz estudo","url":"http://esporte.uol.com.br/futebol/ultimas-noticias/2017/05/11/brasil-e-com-sobras-o-pais-que-mais-exporta-atletas-de-futebol-diz-estudo.htm","startingDate":"20170511132357","endingDate":null,"isClosed":false,"isActive":true,"daysToClose":"15","themeId":"28","repository":"news-esporte","total":"10","replies":"3","highestMessageLikes":"1","totalRatings":"0","totalCommentsWithRatings":"0","totalPendingComments":"1","moderationType":"PRE","like":"0","dislike":"0","recommendNoComment":true,"recommendLimited":false,"replyLevel":"1","image":null,"socialAccount":null,"socialHashtag":null,"allowAnonymousUser":false,"turingOnAnonymousUser":true,"turingUsage":"ANONYMOUS","mediaTags":null,"tags":null,"status":"VISIBLE","moderationStatus":"NONE","hasEditorRecommendation":false,"pinnedMessage":null,"views":"0","ratingCategoryId":null,"ratingAverage":"0.0","lastPostDate":"20170512084033","lastPostUserId":"1046913266814648811","lastPostUserSource":"UOLK","lastPostUserName":"Nelson_juka","lastCodProfile":"7ycbs38xwxd7","lastProfileNick":null,"lastProfileUrl":null,"userId":null,"userSource":null,"userCodProfile":null,"userName":null,"profileNick":null,"profileUrl":null,"hasRating":false,"userRecommendedStatus":"NONE","formConfiguration":null,"theme":{"name":"Esporte","id":28,"total":3699900,"description":"","left":244,"right":245,"order":7,"pending":0,"image":"http://img.uol.com.br/image_src/esporte.gif","socialAccount":"","socialHashtag":"","lastPostUserName":"Celso XML","lastPostUserId":"1762752407906024758","lastPostUserSource":"UOLK","lastPostDate":"20170512101306","views":48,"productGroupId":1,"totalRatings":0,"socialMessage":"Leia meu comentário em \":title:\" // :user: em @UOLEsporte :url:","antifloodTime":20,"maxCharacters":960,"automaticReproveBadword":true,"allowUnregisteredUser":true,"allowSocialNetworkAccess":true,"parentId":109,"totalTopics":0,"complaintId":3,"acceptUsers":false,"quarentineTime":10,"quarentineComments":0,"daysToUnblockUser":30,"hasUserTotal":false,"productSourceId":1,"allowMessageEdit":true,"allowTopicCreation":false,"defaultRepository":{"name":"news-esporte","id":4},"defaultModerationType":"PRE","totalPosts":3699900,"totalPostsWithRatings":0,"subjectUrl":"http://forum.uol.com.br/t/%s/%s","themeUrl":"/f/28/esporte","subjectOwnerCanModerate":false,"clearSignatureText":"","requiresContentAndRating":false,"defaultFormConfiguration":null},"pendingTotal":"0","moderatedTotal":"0"},"error":null})
// da reposta pegar o repositório,

// https://view.comentarios.uol.com.br/subject/13633379?callback=BabelModelCommentsMessages&repository=news-esporte&load_replies=true
// https://view.comentarios.uol.com.br/subject/13633379?callback=BabelModelCommentsMessages&repository=news-esporte&load_replies=true&next=0001H11U10N
// https://view.comentarios.uol.com.br/subject/13633379?callback=BabelModelCommentsMessages&repository=news-esporte&size=5&sort=like%3Adesc%2Ccreated%3Adesc&next=0001H10U5N&load_replies=true