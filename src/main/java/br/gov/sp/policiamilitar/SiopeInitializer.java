package br.gov.sp.policiamilitar;

import br.gov.sp.policiamilitar.business.entities.*;
import br.gov.sp.policiamilitar.business.services.*;
import com.google.common.collect.Iterables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class SiopeInitializer {

    @Autowired
    ContaService contaService;

    @Autowired
    PermissoesService permissoesService;

    @Autowired
    TipoCargoSiopeService tipoCargoSiopeService;

    @Autowired
    CargoSiopeService cargoSiopeService;

    @Autowired
    CargoService cargoService;

    @Autowired
    EscolaService escolaService;

    @PostConstruct
    private void init() {
        carregaAdmin();
        carregaTipoCargoSiope();
        carregaCargoSiope();
        carregaCargos();
        carregaEscolas();
    }

    public void carregaEscolas() {
        if (Iterables.isEmpty(escolaService.findAll())) {
            Escola[] escolas = new Escola[]{
                    //region lista escolas
                    new Escola(35056200L, "14.00.01.06", "UNIDADE MUNICIPAL DE EDUCACAO ALCIDES LOBO VIANA", "ALCIDES LOBO VIANA DOUTOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35191838L, "14.00.02.42", "UNIDADE MUNICIPAL DE EDUCACAO ANIZIO BENTO", "ANIZIO BENTO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056261L, "14.00.01.07", "UNIDADE MUNICIPAL DE EDUCACAO ANTONIO OLIVEIRA PASSOS SOBRINHO", "ANTONIO DE OLIVEIRA PASSOS SOBRINHO PROF UME"),
                    new Escola(35203836L, "14.00.01.19", "UNIDADE MUNICIPAL DE EDUCACAO AUXILIADORA DA INSTRUCAO", "ANTONIO DEMOSTENES DE S BRITO PROF UNIDADE MUN DE EDUCACAO"),
                    new Escola(35056066L, "14.00.01.20", "UNIDADE MUNICIPAL DE EDUCACAO AVELINO DA PAZ VIEIRA", "AUXILIADORA DA INSTRUCAO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35207068L, "14.00.01.21", "UNIDADE MUNICIPAL DE EDUCACAO AYRTON SENNA DA SILVA", "AVELINO DA PAZ VIEIRA PROF UME"),
                    new Escola(35075668L, "14.00.01.22", "UNIDADE MUNICIPAL DE EDUCACAO BARAO DO RIO BRANCO", "AYRTON SENNA DA SILVA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056078L, "14.00.01.02", "UNIDADE MUNICIPAL DE EDUCACAO CANDINHA RIBEIRO DE MENDONCA", "BARAO DO RIO BRANCO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35234825L, "14.00.02.54", "UNIDADE MUNICIPAL DE EDUCACAO CELY DE MOURA NEGRINI", "CANDINHA RIBEIRO DE MENDONCA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056273L, "14.00.01.23", "UNIDADE MUNICIPAL DE EDUCACAO CIDADE DE SANTOS", "CELY DE MOURA NEGRINI PROFA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056085L, "14.00.02.79", "UNIDADE MUNICIPAL DE EDUCACAO CLAUDIA HELENA DOS S. OLIVEIRA CORREA", "CIDADE DE SANTOS UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35480204L, "14.00.02.78", "UNIDADE MUNICIPAL DE EDUCACAO DEPUTADO RUBENS LARA", "CLAUDIA HELENA DOS SANTOS OLIVEIRA CORREA UME"),
                    new Escola(35090924L, "14.00.02.43", "UNIDADE MUNICIPAL DE EDUCACAO DONA HILDA RABACA", "CLOVIS BANDEIRA BRASIL GENERAL UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056212L, "14.00.01.39", "UNIDADE MUNICIPAL DE EDUCACAO DOS ANDRADAS I", "CYRO DE ATHAYDE CARNEIRO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35075681L, "14.00.01.44", "UNIDADE MUNICIPAL DE EDUCACAO DOS ANDRADAS II", "DEROSSE JOSE DE OLIVEIRA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35089977L, "14.00.02.56", "UNIDADE MUNICIPAL DE EDUCACAO DR. CYRO DE ATHAYDE CARNEIRO", "DINO BUENO DOUTOR UME"),
                    new Escola(35430614L, "14.00.01.08", "UNIDADE MUNICIPAL DE EDUCACAO DR. DEROSSE JOSE DE OLIVEIRA", "DOS ANDRADAS II UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35268227L, "14.00.01.24", "UNIDADE MUNICIPAL DE EDUCACAO DR. DINO BUENO", "DOS ANDRADAS UNIDADE MUNINICIPAL DE EDUCACAO"),
                    new Escola(35069619L, "14.00.02.64", "UNIDADE MUNICIPAL DE EDUCACAO DR. FERNANDO COSTA", "EDMEA LADEVIG UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35225617L, "14.00.02.65", "UNIDADE MUNICIPAL DE EDUCACAO DR. JOSE CARLOS DE AZEVEDO JUNIOR", "ELSA VIRTUOSO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35203828L, "14.00.02.66", "UNIDADE MUNICIPAL DE EDUCACAO DR. JOSE DA COSTA E SILVA SOBRINHO", "EMILIA MARIA REIS PROFA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35390872L, "14.00.02.47", "UNIDADE MUNICIPAL DE EDUCACAO DR. LUIZ LOPES", "ESMERALDO TARQUINIO PREFEITO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056297L, "14.00.02.61", "UNIDADE MUNICIPAL DE EDUCACAO DR. NELSON DE TOLEDO PIZA", "EUNICE CALDAS UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056091L, "14.00.01.16", "UNIDADE MUNICIPAL DE EDUCACAO DR. PORCHAT DE ASSIS", "FERNANDO COSTA DOUTOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35194852L, "14.00.02.62", "UNIDADE MUNICIPAL DE EDUCACAO DR. SAMUEL AUGUSTO LEAO DE MOURA", "FLAVIO CIPRIANO BARBOSA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35078924L, "14.00.01.26", "UNIDADE MUNICIPAL DE EDUCACAO EDMEA LADEVIG", "FLORESTAN FERNANDES PROFESSOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35286291L, "14.00.01.09", "UNIDADE MUNICIPAL DE EDUCACAO ELZA VIRTUOSO", "FRANCISCO LEITE PADRE CRECHE MUNICIPAL"),
                    new Escola(35234849L, "14.00.01.10", "UNIDADE MUNICIPAL DE EDUCACAO EUNICE CALDAS", "GEMMA REBELLO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35076843L, "14.00.02.44", "UNIDADE MUNICIPAL DE EDUCACAO FLAVIO CIPRIANO BARBOSA", "GOTA DE LEITE UNIDIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35273934L, "14.00.01.04", "UNIDADE MUNICIPAL DE EDUCACAO GEMMA REBELLO", "HILDA D ONOFRIO PAPA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35234850L, "14.00.02.55", "UNIDADE MUNICIPAL DE EDUCACAO GENERAL CLOVIS BANDEIRA BRASIL", "HILDA RABACA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35653871L, "14.00.01.29", "UNIDADE MUNICIPAL DE EDUCACAO GOTA DE LEITE", "ILHA DIANA UNIDADE MUNICIPAL DE EDUCACAO R"),
                    new Escola(35084475L, "14.00.02.45", "UNIDADE MUNICIPAL DE EDUCACAO HILDA D'ONOFRIO PAPA", "IVETA MESQUITA NOGUEIRA PROFA UME"),
                    new Escola(35078918L, "14.00.01.45", "UNIDADE MUNICIPAL DE EDUCACAO IRMA MARIA DOLORES", "JOAO IGNACIO DE SOUZA VEREADOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35363169L, "14.00.02.67", "UNIDADE MUNICIPAL DE EDUCACAO IRMAO JOSE GENESIO", "JOAO PAPA SOBRINHO PROFESSOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35191814L, "14.00.01.43", "UNIDADE MUNICIPAL DE EDUCACAO JOAO PAPA SOBRINHO", "JOAO WALTER SAMPAIO SMOLKA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35355948L, "14.00.02.48", "UNIDADE MUNICIPAL DE EDUCACAO JOAO WALTER SAMPAIO SMOLKA", "JOSE BONIFACIO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056236L, "14.00.01.42", "UNIDADE MUNICIPAL DE EDUCACAO JOSE BONIFACIO", "JOSE CARLOS AZEVEDO JUNIOR DR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35090013L, "14.00.01.12", "UNIDADE MUNICIPAL DE EDUCACAO JOSE DA COSTA BARBOSA", "JOSE DA COSTA BARBOSA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35207081L, "14.00.01.37", "UNIDADE MUNICIPAL DE EDUCACAO JUDOCA RICARDO SAMPAIO", "JOSE DA COSTA SILVA SOBRINHO DR UNIDADE MUN DE EDUCACAO"),
                    new Escola(35234862L, "14.00.02.49", "UNIDADE MUNICIPAL DE EDUCACAO LAURIVAL RODRIGUES", "JOSE DE SA PORTO PROFESSOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056108L, "14.00.01.13", "UNIDADE MUNICIPAL DE EDUCACAO LEONOR MENDES DE BARROS", "JOSE GENESIO IRMAO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35114315L, "14.00.01.31", "UNIDADE MUNICIPAL DE EDUCACAO LOURDES ORTIZ", "LAURIVAL RODRIGUES UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056145L, "14.00.02.58", "UNIDADE MUNICIPAL DE EDUCACAO LUIZ CARLOS PRESTES", "LEONARDO NUNES PADRE UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056194L, "14.00.01.05", "UNIDADE MUNICIPAL DE EDUCACAO LYDIA FEDERICI", "LEONOR MENDES DE BARROS UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056112L, "14.00.02.70", "UNIDADE MUNICIPAL DE EDUCACAO MARTINS FONTES", "LOURDES ORTIZ UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35356037L, "14.00.01.41", "UNIDADE MUNICIPAL DE EDUCACAO NOEL GOMES FERREIRA", "LUCIO FLORO PADRE UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35203841L, "14.00.01.35", "UNIDADE MUNICIPAL DE EDUCACAO OLAVO BILAC", "LUIZ CARLOS PRESTES UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35191851L, "14.00.01.15", "UNIDADE MUNICIPAL DE EDUCACAO OLIVIA FERNANDES", "LUIZ LOPES DR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35234874L, "14.00.02.63", "UNIDADE MUNICIPAL DE EDUCACAO OSWALDO JUSTO", "LYDIA FEDERICI UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35078906L, "14.00.01.40", "UNIDADE MUNICIPAL DE EDUCACAO PADRE FRANCISCO LEITE", "MAGALI ALONSO PROFESSORA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35079157L, "14.00.02.68", "UNIDADE MUNICIPAL DE EDUCACAO PADRE LEONARDO NUNES", "MARIA CARMELITA P VILLACA UNIDADE MUN DE EDUCACAO ESPECIAL"),
                    new Escola(35203804L, "14.00.02.76", "UNIDADE MUNICIPAL DE EDUCACAO PADRE LUCIO FLORO", "MARIA DE LOURDES B BERNAL PROFA UNID MUNICIPAL DE EDUCACAO"),
                    new Escola(35435521L, "14.00.01.03", "UNIDADE MUNICIPAL DE EDUCACAO PADRE WALDEMAR VALLE MARTINS", "MARIA DOLORES IRMA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35078943L, "14.00.02.71", "UNIDADE MUNICIPAL DE EDUCACAO PEDRO CRESCENTI", "MARIA HELENA ROXO PROFESSORA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35075673L, "14.00.01.36", "UNIDADE MUNICIPAL DE EDUCACAO PEDRO II", "MARIA LUIZA ALONSO SILVA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35191826L, "14.00.02.77", "UNIDADE MUNICIPAL DE EDUCACAO PREFEITO ESMERALDO TARQUINIO", "MARIA LUIZA SIMOES RIBEIRO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056248L, "14.00.01.18", "UNIDADE MUNICIPAL DE EDUCACAO PROF. ANTONIO DEMOSTENES DE SOUZA BRITO", "MARIA PATRICIA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056170L, "14.00.01.17", "UNIDADE MUNICIPAL DE EDUCACAO PROF. MARIA CARMELITA PROOST VILLACA", "MARIO DE ALMEIDA ALCANTARA PROF UNIDADE MUN DE EDUCACAO"),
                    new Escola(35056121L, "14.00.02.69", "UNIDADE MUNICIPAL DE EDUCACAO PROF. MARIA DE LOURDES BORGES BERNAL", "MARTINS FONTES UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35653883L, "14.00.01.28", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSOR FLORESTAN FERNANDES", "MONTE CABRAO UNIDADE MUNICIPAL DE EDUCACAO R"),
                    new Escola(35078931L, "14.00.02.46", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSOR JOSE DE SA' PORTO", "NELSON DE TOLEDO PIZA DOUTOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35363157L, "14.00.01.33", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSOR MARIO DE ALMEIDA ALCANTARA", "NOEL GOMES FERREIRA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056133L, "14.00.02.74", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSOR WALDERY DE ALMEIDA", "OLAVO BILAC UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056259L, "14.00.01.27", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA EMILIA MARIA REIS", "OLIVIA FERNANDES UNIDIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35194864L, "14.00.01.11", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA IVETA MESQUITA OLIVEIRA", "OSWALDO JUSTO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35207073L, "14.00.02.59", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA MAGALI ALONSO", "PEDRO CRESCENTI PROFESSOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056157L, "14.00.01.14", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA MARIA HELENA ROXO", "PEDRO II UNIDIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35056224L, "14.00.01.32", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA MARIA LUIZA ALONSO SILVA", "PORCHAT DE ASSIS DOUTOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35236597L, "14.00.02.50", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA MARIA LUIZA SIMOES RIBEIRO", "REGINA ALTMAN UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35207093L, "14.00.02.60", "UNIDADE MUNICIPAL DE EDUCACAO PROFESSORA MARIA PATRICIA", "RICARDO SAMPAIO CARDOSO JUDOCA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35429983L, "14.00.02.52", "UNIDADE MUNICIPAL DE EDUCACAO REGINA ALTMAN", "RUBENS LARA DEPUTADO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35082077L, "14.00.01.30", "UNIDADE MUNICIPAL DE EDUCACAO RURAL ILHA DIANA", "SAMUEL AUGUSTO LEAO MOURA DR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35191848L, "14.00.01.34", "UNIDADE MUNICIPAL DE EDUCACAO RURAL MONTE CABRAO", "SANDRA CRISTINA TEIXIERA DA GAMA UNIDADE MUN DE EDUCACAO"),
                    new Escola(35565726L, "14.00.02.51", "UNIDADE MUNICIPAL DE EDUCACAO SANDRA CRISTINA TEIXEIRA GAMA", "SANTISTA UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35245999L, "14.00.01.46", "UNIDADE MUNICIPAL DE EDUCACAO SANTISTA", "THEREZINHA DE JESUS SIQUEIRA PIMENTEL UNIDA MUN DE EDUCACAO"),
                    new Escola(35069607L, "14.00.02.72", "UNIDADE MUNICIPAL DE EDUCACAO THEREZINHA DE JESUS SIQUEIRA PIMENTEL", "VINTE E OITO DE FEVEREIRO UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35409406L, "14.00.02.57", "UNIDADE MUNICIPAL DE EDUCACAO VEREADOR JOAO IGNACIO DE SOUZA", "WALDEMAR VALLE MARTINS PADRE UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35203816L, "14.00.02.73", "UNIDADE MUNICIPAL DE EDUCACAO VINTE E OITO DE FEVEREIRO", "WALDERY DE ALMEIDA PROFESSOR UNIDADE MUNICIPAL DE EDUCACAO"),
                    new Escola(35234886L, "14.00.02.53", "UNIDADE MUNICIPAL DE EDUCACAO YARA NASCIMENTO SANTINI", "YARA NASCIMENTO SANTIN I UNIDADE MUNICIPAL DE EDUCACAO")
            };
            //endregion
            for (Escola escola : escolas) {
                escolaService.addOrUpdate(escola);
            }
        }
    }

    public void carregaTipoCargoSiope() {
        if (Iterables.isEmpty(tipoCargoSiopeService.findAll())) {
            TipoCargoSiope[] objs = new TipoCargoSiope[]{
                new TipoCargoSiope("Profissionais do magistério"),
                new TipoCargoSiope("Outros profissionais da educação")
            };
            for (TipoCargoSiope obj : objs) {
                tipoCargoSiopeService.addOrUpdate(obj);
            }
        }
    }

    public void carregaCargoSiope() {
        if (Iterables.isEmpty(cargoSiopeService.findAll())) {
            CargoSiope[] objs = new CargoSiope[]{
                    //region lista CargosSIOPE
                    new CargoSiope("Docente habilitado em curso de nível médio", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente habilitado em curso de pedagogia", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente habilitado em curso de licenciatura plena", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente habilitado em programa especial de formação pedagógica de docentes ", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente pós-graduado em cursos de especialização para formação de docentes para educação profissional técnica de nível médio", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente graduado bacharel e tecnólogo com diploma de mestrado ou doutorado na área do componente curricular da educação profissional técnica de nível médio", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente professor indígena sem prévia formação pedagógica ", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente instrutor, tradutor e intérprete de libras. ", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Docente professor de comunidade quilombola ", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Profissionais não habilitados, porém autorizados a exercer a docência em caráter precário e provisório na educação infantil e nos anos iniciais do ensino fundamental.", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Profissionais graduados, bacharéis e tecnólogos autorizados a atuar como docentes, em caráter precário e provisório, nos anos finais do ensino fundamental e no ensino médio e médio integrado à educação.", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Profissionais experientes, não graduados, autorizados a atuar como docentes, em caráter precário e provisório, no ensino médio e médio integrado à educação profissional técnica de nível médio.", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Profissionais em efetivo exercício no âmbito da educação infantil e ensino fundamental.", tipoCargoSiopeService.findOne(1L)),
                    new CargoSiope("Auxiliar/Assistente Educacional ", tipoCargoSiopeService.findOne(2L)),
                    new CargoSiope("Profissionais que exercem funções de secretaria escolar, alimentação escolar (merendeiras), multimeios didáticos e infraestrutura.", tipoCargoSiopeService.findOne(2L)),
                    new CargoSiope("Profissionais que atuam na realização das atividades requeridos nos ambientes desecretaria, de manutenção em geral. ", tipoCargoSiopeService.findOne(2L))
                    //endregion
            };
            for (CargoSiope obj : objs) {
                obj.setTipoCargoSiope(obj.getTipoCargoSiope());
                cargoSiopeService.addOrUpdate(obj);
            }
        }
    }

    public void carregaCargos() {
        if (Iterables.isEmpty(cargoService.findAll())) {
            Cargo[] cargos = new Cargo[]{
                    //region listaCargoSiope
                    new Cargo("EDUCADOR DE DESENV. INFANT", cargoSiopeService.findOne(1L)),
                    new Cargo("MERENDEIRA", cargoSiopeService.findOne(15L)),
                    new Cargo("OFICIAL DE ADMINISTRACAO", cargoSiopeService.findOne(15L)),
                    new Cargo("AUXILIAR DE SERV. GERAIS", cargoSiopeService.findOne(15L)),
                    new Cargo("COZINHEIRO", cargoSiopeService.findOne(15L)),
                    new Cargo("AUX.DE BIBLIOTECARIO", cargoSiopeService.findOne(15L)),
                    new Cargo("INSPETOR DE ALUNOS", cargoSiopeService.findOne(15L)),
                    new Cargo("SECRET. DE UNIDADE ESCOLAR", cargoSiopeService.findOne(15L)),
                    new Cargo("AGENTE DE PORTARIA", cargoSiopeService.findOne(15L)),
                    new Cargo("AGENTE ADMINISTRATIVO", cargoSiopeService.findOne(15L)),
                    new Cargo("INTERPRETE DE LIBRAS", cargoSiopeService.findOne(8L)),
                    new Cargo("COORDENADOR II", cargoSiopeService.findOne(15L)),
                    new Cargo("GUARDA", cargoSiopeService.findOne(15L)),
                    new Cargo("TERAPEUTA OCUPACIONAL", cargoSiopeService.findOne(15L)),
                    new Cargo("TECNICO DE BIBLIOTECONOMIA", cargoSiopeService.findOne(15L)),
                    new Cargo("ORIENT.ESTAC.REGULAMENTADO", cargoSiopeService.findOne(15L)),
                    new Cargo("PEDREIRO", cargoSiopeService.findOne(15L)),
                    new Cargo("MECANICO", cargoSiopeService.findOne(15L)),
                    new Cargo("AJUDANTE DE COZINHA", cargoSiopeService.findOne(15L)),
                    new Cargo("CALCETEIRO", cargoSiopeService.findOne(15L)),
                    new Cargo("CANTEIRO", cargoSiopeService.findOne(15L)),
                    new Cargo("ESP.ED.I-ORIENT.EDUCACIONA", cargoSiopeService.findOne(2L)),
                    new Cargo("ESP.ED.II-DIRETOR DE UNIDA", cargoSiopeService.findOne(2L)),
                    new Cargo("ESP.ED.I-ASSIST.DE DIRECAO", cargoSiopeService.findOne(2L)),
                    new Cargo("ESP.ED.I-COORD. PEDAGOGICO", cargoSiopeService.findOne(2L)),
                    new Cargo("PROF. ED. BASICA I", cargoSiopeService.findOne(2L)),
                    new Cargo("PROF. ADJUNTO I", cargoSiopeService.findOne(2L)),
                    new Cargo("PROF. ED. BASICA II", cargoSiopeService.findOne(2L)),
                    new Cargo("PROF. ADJUNTO II", cargoSiopeService.findOne(2L)),
                    new Cargo("PROF.EDUC.FISICA", cargoSiopeService.findOne(3L)),
                    //endregion
            };
            for (Cargo cargo : cargos) {
                cargo.setCargoSiope(cargo.getCargoSiope());
                cargoService.addOrUpdate(cargo);
            }
        }
    }

    private void carregaAdmin() {
        Conta admin = contaService.findbyLogin("admin");
        Permissoes permissao = permissoesService.findByDescPermissoes("Admin");
        Permissoes permissao1 = permissoesService.findByDescPermissoes("User");

        try {
            if (permissao == null) {
                permissao = new Permissoes(0, "Admin");
                permissao = permissoesService.addOrUpdate(permissao);
                permissao1 = new Permissoes(0, "User");
                permissao1 = permissoesService.addOrUpdate(permissao1);
            }
            //If the application is started for the first time (e.g., the admin is not in the DB)
            if (admin == null) {
                BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                //create a user for the admin
                admin = new Conta();
                //and fill her attributes accordingly
                admin.setUsername("admin");
                //admin.setPassword(passwordEncoder.encode("qwert"));
                admin.setPassword("qwert");
                List<Permissoes> permissoesList = new ArrayList<Permissoes>();
                permissoesList.add(permissao);
                permissoesList.add(permissao1);
                admin.setPermissoes(permissoesList);
                contaService.addOrUpdate(admin);
                Conta user = new Conta();
                user.setUsername("user");
                user.setPassword(passwordEncoder.encode("qwert"));
                user.setPassword("qwert");
                permissoesList.clear();
                permissoesList.add(permissao1);
                user.setPermissoes(permissoesList);
                contaService.addOrUpdate(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro na inicializacao, gentileza verificar.");
        }
    }
}