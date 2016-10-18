    {
        "watch movie" | FO["netflix", "match rank" | "matchrank" | "movies" | "list" | "pairings"] :>
            "E:\\Users\\Daniel\\Documents\\NetflixMatchRank.nb",
        FO[
            "copying" | "copy" | "move" | "moving" | "transfer" | "transfering",
            "file" | "files",
            op["to"],
            op["my" | "the"],
            "laptop"
        ] :>
            "CopyingFilesToLaptop.nb",
        FO["juicy", "projects"] :> "JuicyProjects.nb",
        FO["dirichlet"] :> "Dirichlet.nb",
        FO["dirichlet", "distribution"] :> "DirichletDistribution2.nb",
        FO[op["my"], "notes"] :> "MyNotes.nb",
        sym["$lm"] | FO["$nlu" | sym["$lang"], "models" | "modeling"] | "nlpmodels" :>
            "NlpModels.nb",
        FO["todo"] :> "Todo.nb",
        FO["ideas"] :> "Ideas.nb",
        FO["today"] :> "Today.nb",
        FO[op["enter"], "food", "prices"] :> "EnterFoodPrices.nb",
        FO[op["enter"], "food", op["store"], "locations"] :> "EnterFoodStoreLocations.nb",
        FO["semantics"] :> "Semantics.nb",
        FO["juicy", "projects"] :> "JuicyProjects.nb",
        FO["sequence", op["parser"], op["learning"]] :> "SequenceParserLearning.nb",
        FO["stack"] :> "Todo.nb",
        FO["learning"] :> "Learning.nb",
        FO["books", "and", "courses"] | "books" | "courses" | "courses and books" :>
            "BooksAndCourses.nb",
        FO["probability"] :> "Probability.nb",
        AO["coursera", "nlp"] :> "CourseraNlp.nb",
        AO["coursera", "pgm"] :> "CourseraPgm.nb",
        FO["machine" | "ml", "learning"] :> "MachineLearning.nb",
        FO[sym["$markov"]] :> "Markov2.nb",
        sym["$ng"] :> "NGParser.nb",
        "am" | "argm" | "argmeet" | FO["arg", "meeting" | "meetings"] :> "ArgMeeting.nb",
        FO["neural", "networks" | "net" | "nets"] | "neural" :> "NeuralNetworks.nb",
        FO["recurrent" | FO["recurrent neural", "nets" | "networks"]] :> "Recurrent.nb",
        AO["columbia", op["coursera"], "nlp", op["course"], sym["$notebook"]] :> "ColumbiaNlp.nb",
        FO["grammar"] :> "Grammar.nb",
        FO["semantic", "inference"] | "SemanticInference" :> "SemanticInference.nb",
        FO["semantic", "graph"] :> "SemanticGraph.nb",
        FO["sr"] :> "SR.nb",
        FO["nlu"] :> "NLU.nb",
        FO["entity" | "entities"] :> "Entities.nb",
        "nlpro" | "nlprog" | "nlprogramming" | FO["nl" | "nlp", "programming" | "prog"] :>
            "NlProgramming.nb",
        FO["eli", "game"] :> "EliGame.nb",
        FO[sym["$ng"], "functions"] :> "NgFunctions.nb",
        FO["personal"] :> "Personal.nb",
        FO[sym["$kn"], op[FO[op["language"], "smoothing"]]] :> "KneserNey.nb",
        FO[op["nlp" | "language model"], "smoothing", op["techniques"]] :> "Smoothing.nb",
        FO["pruning", op["count"]] :> "LanguageModelPruning.nb",
        FO["katz", op[FO[op["language"], "smoothing" | "discounting" | "discount" | "backoff"]]] :>
            "Katz.nb",
        FO["continuation", "probability"] :> "ContinuationProbability.nb",
        FO["implicit", "entities" | "entity"] :> "ImplicitEntities.nb",
        Alternatives[
            "ImplicitEntityClass",
            "ImplicitEntityClasses",
            FO["implicit", "entity", "class" | "classes"]
        ] :>
            "ImplicitEntityClass.nb",
        FO["restricted"] :> "Restricted.nb",
        FO[sym["$kn"], "paper"] :> "KneserNeyPaper.nb",
        FO["poset"] :> "Poset.nb",
        Alternatives[
            "genutil",
            "genutils",
            "gutil",
            "gutils",
            "GeneralUtilities",
            FO["general", "utilities"]
        ] :>
            "GeneralUtilities.nb",
        FO[sym["$kn"], sym["$impl"]] :> "KneserNeyImplementation.nb",
        FO["good", "turing"] :> "GoodTuring.nb",
        "unknown token" | "unknown token probability" | "UnknownTokenProbability" | "utp" :>
            "UTP.nb",
        AO[op["stanley"], op["chen"], op["joshua"], op["goodman"], op["99" | "1999"], "paper"] :>
            "StanleyChen99.nb",
        AO[
            Alternatives[
                FO[op["stanley"], "chen"],
                FO[op["joshua"], "goodman"],
                AO[FO[op["stanley"], "chen"], FO[op["joshua"], "goodman"]]
            ],
            op["99" | "1999"],
            op["paper"]
        ] :>
            "StanleyChen99.nb",
        "mkns" | FO["modified", sym["$kn"], op["smoothing"]] :> "ModifiedKneserNey.nb",
        FO["perplexity"] :> "Perplexity.nb",
        FO["cross", "entropy"] :> "CrossEntropy.nb",
        FO[sym["$kn"], "equations" | "equation"] :> "KnEquations.nb",
        FO["hidden", "markov", "model" | "models"] | FO["hmm"] :> "HMM.nb",
        FO["iii"] :> "Blah2.nb",
        FO["djb3"] :> "Personal.nb",
        FO["people"] :> "People.nb",
        FO["walking" | "walks", op["log"]] :> "Walking.nb",
        FO["semantic", "system"] :> "SemanticSystem.nb",
        FO[op[sym["$my"]], op[sym["$bb"]], "z10", op["phone" | "smartphone" | "device"]] :>
            "Z10.nb",
        FO["tech" | "technology", "synergy"] :> "TechSynergy.nb",
        FO["family", "journal"] :> "FamilyJournal.nb",
        FO["semantics" | "semantic", "ideas"] :> "SemanticsIdeas.nb",
        Alternatives[
            "sha",
            FO[
                "sorted hash association",
                "sorted hash array",
                "SortedHashAssociation",
                "SortedHashArray"
            ]
        ] :>
            "Sha.nb",
        FO["jlink"] :> "JLink.nb",
        "matrices" | "matrixes" | FO["matrix"] :> "Matrices.nb",
        "sparse array" | FO["sparsearray"] :> "SparseArray.nb",
        FO["etienne"] :> "Etienne.nb",
        AO[
            op[sym["$kn"]],
            "speech" | "speech recognition" | "sr",
            op[sym["$lang"]],
            "model",
            op["sebastian" | "seb"]
        ] :>
            "KnLanguageModelForSebastian.nb",
        FO["ngrams"] :> "NGrams.nb",
        FO["Blah103"] :> "Blah103.nb",
        FO["Blah104"] :> "Blah104.nb",
        FO[sym["$curt"]] :> "CurtisBeattie.nb",
        AO["linguistic" | "linguistics", "bindings" | "binding" | "mapping" | "mappings"] :>
            "LinguisticBindings.nb",
        FO["Linguistics" | "spellings"] :> "Linguistics.nb",
        "AutomatedInsights" | FO["automated", "insights"] :> "AutomatedInsights.nb",
        "text generation" | "text creation" | "sr to text" | FO["SrToText"] :> "SrToText.nb",
        FO["ARPA"] :> "ARPA.nb",
        "ken lm" | FO["kenlm"] :> "kenlm.nb",
        FO["Hours"] :> "Hours.nb",
        FO["jlink", "lockup"] :> "JLinkLockup.nb",
        "vs" | FO["Visual Studio"] :> "VisualStudio.nb",
        Alternatives[
            "MarkovLM",
            FO[sym["$markov"], CalculateParse`GrammarSyntax`FO[sym["$lang"], "model" | "models"]]
        ] :>
            "MarkovLM.nb",
        FO[op[sym["$lang"]], op["model"], "corpi" | "corpora" | "corpus"] :> "Corpus.nb",
        FO["SRILM"] :> "SRILM.nb",
        FO[sym["$lm"] | sym["$nlu"], "software" | "tools" | "toolkit" | "toolkits"] :>
            "LanguageModelSoftware.nb",
        FO["Kylm"] :> "Kylm.nb",
        AO["Compare", sym["$lm"] | sym["$kn"]] :> "CompareLanguageModel.nb",
        "profile" | "profiler" | "profiling" | "djb profiler" | "my profiler" | FO["DjbProfiler"] :>
            "DjbProfiler.nb",
        "TextCases" | FO["text", "cases"] :> "TextCases.nb",
        FO["owl" | "owl2"] :> "OWL.nb",
        "JavaTokenizer" | "jtok" | "jtokenizer" | FO["Java Tokenizer"] :> "JavaTokenizer.nb",
        AO["mtrott", "resources" | "papers" | "books"] :> "mtrottResources.nb",
        FO["entity" | "semantic" | "semantics", "papers" | "books" | "resources"] :>
            "EntityPapers.nb",
        FO["Entity", "meeting" | "Meetings"] :> "EntityMeetings.nb",
        FO["entity", "terms"] :> "EntityTerms.nb",
        FO["Postbox"] :> "Postbox.nb",
        FO["Donations" | "giving"] :> "Donations.nb",
        FO["Word", "Frequency" | "frequencies"] :> "WordFrequency.nb",
        FO[op["Default"], "Notebook", "Path" | "directory" | "dir"] :> "DefaultNotebookPath.nb",
        FO[sym["$kn"], "testing"] :> "KnTesting.nb",
        FO["Formatting"] :> "Formatting.nb",
        FO["VPN"] :> "VPN.nb",
        AO[sym["$ng"], "file" | "files", "reloading"] :> "NgFileReloading.nb",
        FO[sym["$ng"], "killer", "app" | "apps"] :> "NgKillerApp.nb",
        FO[sym["$bot"]] :> "Chatbots.nb",
        FO[sym["$wl"], "Chatbot"] :> "WLChatbot.nb",
        "floss" | "flossing" :> "Flossing.nb",
        Alternatives[
            sym["$ling"],
            "generalization",
            FO[op["learn" | "learning"], op[sym["$ling"]], "From" | "by", "example" | "Examples"]
        ] :>
            "LinguisticsFromExamples.nb",
        FO["c", op["code"]] :> "C.nb",
        FO[op["CMU"], "Sphinx"] :> "CMUSphinx.nb",
        FO[sym["$wl"], "Scripting" | "scripts"] :> "WolframLanguageScripting.nb",
        "CtrlQ" | FO["ctrl", "Q"] :> "CtrlQ.nb",
        FO[op["load" | "loading"], "Markov", Alternatives[FO["Without", "Alpha"]]] :>
            "MarkovWithoutAlpha.nb",
        FO[
            "Prune" | "remove",
            Alternatives[
                "Sentences",
                "lines",
                FO["lang", "file"],
                "training set",
                "test set",
                "validation set"
            ]
        ] :>
            "PruneSentences.nb",
        AO[
            "perplexity" | "probability" | "log probability",
            op["of"],
            op["a"],
            "file" | "files" | "test set" | "validation set"
        ] :>
            "MarkovPerplexityOfFile2.nb",
        AO[sym["$libri"], "Trigram" | "trigrams", op["Words" | "word"], op[sym["$lm"]]] :>
            "LibrispeechTrigramWords.nb",
        FO["or", "hack"] :> "ConcatWithOr.nb",
        FO["Kn", "Memory", op["Profiling" | "usage"], op["analysis"]] :> "KnMemoryProfiling.nb",
        FO["memory"] :> "Memory.nb",
        FO["pli", "profiler"] :> "PLIProfiler.nb",
        AO[op["pli"], "java", op["dt"], "linguistics" | "spellings"] :> "DefineJavaDtSpellings.nb",
        FO["Merged", "Markov", "Model"] :> "MergedMarkovModel.nb",
        "SortedHashAssociation" | FO["Sorted", "Hash", "Association" | "array"] :>
            "SortedHashAssociation.nb",
        FO[op[sym["$markov"]], "integer", "tokens"] :> "MarkovIntegerTokens.nb",
        FO["mx", op["file" | "files"]] :> "MX.nb",
        FO["mx", op["files" | "file"]] :> "MX.nb",
        FO[sym["$libri"], op["corpus"]] :> "Librispeech.nb",
        "MainLoopInJava" | AO["main", op["tokenizer"], "loop", op["running"], op["in"], "java"] :>
            "MainLoopInJava2.nb",
        FO["matrix", "inversion", "example"] :> "MatrixInversionExample.nb",
        FO["semantic", "concepts" | "concept"] :> "SemanticConcepts.nb",
        FO["spaces", "vs", "tabs"] :> "SpacesVsTabs.nb",
        FO["testing" | "test", "framework"] :> "TestingFramework.nb",
        FO["private", "symbols"] :> "MLPrivateSymbols.nb",
        FO["git"] :> "Git.nb",
        FO["symbol", "to", "private"] | FO["make", "symbol", "private"] :> "MakeSymbolPrivate.nb",
        "SequencePredict" | FO["sequence", "predict"] :> "SequencePredict.nb",
        FO["low", "hanging", "fruit"] :> "LowHangingFruit.nb",
        sym["$bot"] | "assistants" | FO[op["virtual"], "digital", "assistants"] :>
            "DigitalAssistants.nb",
        FO["just", "testing"] :> "EditLinguistics.nb",
        "wlprofiling" | "wl profiling" | "mprofiling" | "m profiling" | "mathematica profiling" :>
            "WLProfiling.nb",
        "DateDifference" | FO["date", "difference"] :> "DateDifference.nb",
        "data bin" | FO["Databin"] :> "Databin.nb",
        FO["sc"] :> "SC.nb",
        FO[op["twins"], "hernia"] :> "Hernia.nb",
        FO["olive"] :> "Olive.nb",
        FO["emma"] :> "Emma.nb",
        FO["twins"] :> "Twins.nb",
        FO[sym["$va"]] :> "VirtualAssistant2.nb",
        FO[op["help"], "grandma"] :> "Grandma.nb",
        FO["compassion", op["canada"]] :> "Compassion.nb",
        AO[sym["$kn"], sym["$lm"]] :> "LanguageModel.nb",
        FO["model", "3"] :> "Model3.nb",
        FO["concept" | "concepts", "library" | "lib"] :> "ConceptLibrary.nb",
        FO["concepts"] :> "Concepts.nb",
        FO["tesla"] :> "Tesla.nb",
        Alternatives[
            "acars",
            FO[
                "autonomous" | "auton" | "self driving" | "self-driving",
                op["cars" | "vehicles" | "car" | "vehicle" | "driving"]
            ]
        ] :>
            "AutonomousCars.nb",
        "techj" | FO["tech" | "technology", "journal"] :> "TechJournal.nb",
        FO["key", "concepts"] :> "KeyConcepts.nb",
        FO[op["search"], "email", "grammar"] :> "SearchEmailGrammar.nb",
        FO["hyperloop"] :> "Hyperloop.nb",
        "bo" | FO["blue", "origin"] :> "BlueOrigin.nb",
        FO[sym["$spacex"]] :> "SpaceX.nb",
        FO["diaper", "changes"] :> "DiaperChanges.nb",
        FO[sym["$ps"]] :> "Photostar.nb",
        FO[sym["$ng"], "design"] :> "NgDesign.nb",
        FO[sym["$ng"], "concept", "design"] :> "NgConceptDesign.nb",
        FO[op["man" | "men" | "people"], op["on"], op["the"], "moon"] :> "PeopleOnMoon.nb",
        FO["space"] :> "Space.nb",
        FO["genetics"] :> "Genetics.nb",
        FO["mars"] :> "Mars.nb",
        "fh" | FO["falcon", "heavy"] :> "FalconHeavy.nb",
        AO[
            op["booster" | "first stage" | "rocket"],
            op["falcon"],
            op["9"],
            "reuse" | "reusing" | "reusability" | "recovery"
        ] :>
            "FalconReuse.nb",
        FO[sym["$ng"], sym["$ling"], "design"] :> "NgLinguisticsDesign.nb",
        FO["verbs"] :> "Verbs.nb",
        FO["cgel", "ch" | "chapter", "3", "notes"] :> "CgelCh3Notes.nb",
        FO["internet", op["problem" | "problems"]] :> "InternetProblems.nb",
        FO["fusion"] :> "Fusion.nb",
        FO["powerwall"] :> "Powerwall.nb",
        FO["solar", op["power"]] :> "Solar.nb",
        "its" | "syncforitunes" | "itunessync" | "itunes sync" | "sync for itunes" | "sync" :>
            "SyncForITunes.nb",
        FO["superchargers"] :> "Superchargers.nb",
        FO["random" | "rand", "ideas"] :> "RandomIdeas.nb",
        FO["hazel"] :> "Hazel.nb",
        FO["graham", op["huber"]] :> "Graham.nb",
        FO["consciousness" | "cons" | "consc"] :> "Consciousness.nb",
        FO["association" | "assoc" | "associations"] :> "Association.nb",
        FO["lens"] :> "Lens.nb",
        FO["sponsor", "child" | "children"] :> "SponsorChildren.nb",
        Alternatives[
            "mclassify",
            FO["classify" | "classification" | "classifier", "integration"],
            FO[sym["$markov"], "classify" | "classification" | "classifier"]
        ] :>
            "ClassifyIntegration.nb",
        "TokenSet" | FO["token", "set"] :> "MarkovTokenSet.nb",
        FO["nominal"] :> "Nominal.nb",
        FO[sym["$lm"], "papers"] :> "LanguageModelPapers.nb",
        FO[sym["$ml"], "data", "framework"] :> "MlDataFramework.nb",
        "datasets" | "dataset" | FO["data", "sets" | "set"] :> "DataSets.nb",
        "mongodb" | FO["mongo", "db"] :> "MongoDb.nb",
        FO["frameworks"] :> "Frameworks.nb",
        "arg" | FO["arg" | sym["$ml"], sym["$dept"]] :> "MlGroup.nb",
        FO["satellite" | "sat", "internet"] :> "SatelliteInternet.nb",
        FO[sym["$lang"], "classifier"] :> "MarkovLanguageClassifier.nb",
        "AbortMachineLearning" | FO["abort", "machine", "learning"] :> "AbortMachineLearning.nb",
        FO[sym["$markov"], "classifier", "messages" | "msgs"] :> "MarkovClassifierMessages.nb",
        "FilterOptions" | FO["filter", "options"] :> "FilterOptions.nb",
        "markdown" | "md" | "md file" | "md files" | "README.md" | "readme" | "readme md" :>
            "ReadmeMd.nb",
        FO["science"] :> "Science.nb",
        FO["wa" | "alpha", "parser"] :> "Parser.nb",
        FO["java", "dts" | "domain tokenizers"] :> "JavaDts.nb",
        FO["WordData" | "word data", op["java"], "dt"] :> "WordDataDt.nb",
        FO["markov", "language" | "lang", "classifier"] :> "MarkovLanguageClassifier.nb",
        FO[sym["$markov"], "classify", "examples"] :> "MarkovClassifyExamples.nb",
        AO["choose" | "choosing" | "heuristics", "markov order" | "MarkovOrder"] :>
            "MarkovOrderHeuristics.nb",
        FO["storage" | "ssd"] :> "Storage.nb",
        FO["iot" | "internet of things"] :> "IoT.nb",
        "teksavvy" | FO["tek", "savvy"] :> "TekSavvy.nb",
        FO["florida"] :> "Florida.nb",
        FO["commercial", "crew"] :> "CommercialCrew.nb",
        FO[sym["$classify"], sym["$lang"], sym["$classify"]] :> "ClassifyLanguageClassifier.nb",
        FO["virgin", "galactic"] :> "VirginGalactic.nb",
        FO["tesla", "energy"] :> "TeslaEnergy.nb",
        FO["gigafactory"] :> "Gigafactory.nb",
        FO["tesla", "energy"] :> "TeslaEnergy.nb",
        FO["pop"] :> "Pop.nb",
        FO["bloom", "filter"] :> "BloomFilter.nb",
        FO["perfect", "hash"] :> "PerfectHash.nb",
        "dbca" | "danielbighamca" | "danielbigham.ca" | FO[op["my"], "website"] :>
            "DanielBighamCa.nb",
        FO["flight", "simulator" | "sim"] :> "FlightSimulator.nb",
        FO["gathering", op["church"]] :> "Gathering.nb",
        FO["download" | "update", "mathematica"] :> "DownloadMathematica.nb",
        FO["gpu" | "gpus"] :> "GPU.nb",
        FO["cpu" | "cpus"] :> "CPU.nb",
        "extracting facts" | "FactExtract" | FO["fact", "extract" | "extraction"] :>
            "FactExtract.nb",
        "vr" | FO["virtual reality"] :> "VR.nb",
        FO["ses9" | "ses 9" | "ses-9"] :> "ses9.nb",
        "39a" | FO["lc", op["-"], "39a"] :> "LC39A.nb",
        "kenlmi" | "kenlminteg" | FO["kenlm", "integration" | "integ"] :> "KenLMIntegration.nb",
        FO["build", op["small"], "arpa", op["file"]] | FO["small", "arpa", op["file"]] :>
            "BuildSmallARPA.nb",
        "brownsville" | FO["boca", "chica"] :> "BocaChica.nb",
        FO["introspect", sym["$lm"]] :> "IntrospectLanguageModel.nb",
        "arpa sample" | FO["sample", "arpa", op["file"]] :> "SampleARPA.nb",
        FO["sample arpa", op["file"]] | FO["arpa", "sample"] :> "SampleARPA.nb",
        FO[op["load"], "large" | "huge", "arpa", op["file"]] :> "LoadLargeARPAFile.nb",
        FO["graphics"] :> "Graphics.nb",
        FO["windows" | "win", "10"] :> "Windows10.nb",
        FO["likelihood"] | "log likelihood" :> "Likelihood.nb",
        FO["sw"] :> "sw.nb",
        "aimeta" | FO["ai", "metasemantics" | "meta"] :> "AIMetasemantics.nb",
        FO["robotics" | "robots"] :> "Robotics.nb",
        "package delivery" | FO["autonomous" | "automated", op["package"], "delivery"] :>
            "AutonomousDelivery.nb",
        FO["drones" | "uav" | "uavs"] :> "Drones.nb",
        FO["disease" | "diseases"] :> "Disease.nb",
        FO["classification", "data sets" | "datasets"] :> "ClassificationDataSets.nb",
        "ev" | "evs" | FO["electric", "vehicles" | "vehicle"] :> "ElectricVehicles.nb",
        FO["drugs"] :> "Drugs.nb",
        FO["list"] :> "List.nb",
        FO["packed", "array" | "arrays"] :> "PackedArray.nb",
        FO["check", "packed", "array" | "arrays"] :> "PackedArrayCheck.nb",
        FO["canonical" | "example", "sentences"] :> "CanonicalSentences.nb",
        AO["integrating" | "integ" | "integration", "C" | "c++", op["code"]] :>
            "IntegratingCCode.nb",
        FO["passports"] :> "Passports.nb",
        Alternatives[
            "words as vectors",
            "words as a vector",
            "word as a vector",
            FO["word", "embeddings" | "embedding" | "vector" | "vectors"]
        ] :>
            "WordVectors.nb",
        AO["train", op["from"], "arpa", op["file"]] :> "TrainLanguageModelFromARPAFile.nb",
        FO["release", sym["$ps"]] :> "ReleasePhotoStar.nb",
        FO[
            "profile",
            Alternatives[
                "mntd",
                "ntd",
                "next token",
                "next token dist",
                "next token distr",
                "MarkovNextTokenDistribution"
            ]
        ] :>
            "ProfileMarkovNextTokenDistribution.nb",
        FO["barge", "landings" | "landing"] :> "BargeLandings.nb",
        FO["land", "landings" | "landing"] :> "LandLandings.nb",
        FO["c" | "c++", "code"] :> "IntegratingCCode.nb",
        FO["c" | "c++", "library" | "lib" | "libraries"] :> "CLibraries.nb",
        "librarylink" | FO["library", "link"] :> "LibraryLink.nb",
        FO["components"] :> "Components.nb",
        FO["kenlm", "vocab" | "vocabulary"] :> "KenLMVocabulary.nb",
        AO["c" | "c++", op["code"], "integ" | "integration" | "integrating" | "integrated"] :>
            "IntegratingCCode.nb",
        FO["visual studio" | "vs", "2013"] :> "VisualStudio2013.nb",
        "ProcessLink" | FO["process", "link"] :> "ProcessLink.nb",
        FO["ai" | "artificial intelligence"] :> "AI.nb",
        FO["crs", op["-"], "8"] :> VaScore["crs8.nb", 0.99],
        FO[op["income"], "taxes" | "tax"] :> "Taxes.nb",
        "PacletInfo" | FO["paclet", "info"] :> "PacletInfo.nb",
        FO["text cases" | "TextCases", "lexicon" | "lex", op["build"]] :>
            "TextCasesLexiconBuild.nb",
        "lexmx" | FO["lexicon" | "lex", op["build"], "mx", op["file"]] :> "LexiconBuildMXFile.nb",
        FO["lexicon" | "lex", "build"] :> "LexiconBuild.nb",
        FO["profile", op["picture" | "photo"]] :> "ProfilePicture.nb",
        FO["farzad"] :> "Farzad.nb",
        "asds" | FO["drone", "ships"] :> "DroneShips.nb",
        Alternatives[
            FO[sym["$spacex"], "constellation"],
            FO[
                op[sym["$spacex"]],
                Alternatives[
                    "satellite" | "satellites" | "sat",
                    FO["satellite" | "satellites" | "sat", "constellation" | "const"]
                ],
                op["constellation" | "const"]
            ]
        ] :>
            "SpaceXConstellation.nb",
        FO["paclets" | "paclet"] :> "Paclets.nb",
        FO[sym["$ts"]] :> "TextSearchMain.nb",
        FO[sym["$ts"], "meetings" | "meeting"] :> "TextSearchMeetings.nb",
        FO["polysemy"] :> "Polysemy.nb",
        "machine learning" | FO["ml"] :> "ML.nb",
        FO["probabilistic" | "prob", "programming"] :> "ProbabilisticProgramming.nb",
        "wsd" | FO["word", "sense", "disambiguation"] :> "WordSenseDisambiguation.nb",
        FO["text search" | "TextSearch" | "ts", "research"] :> "TextSearchResearch.nb",
        "svd" | FO["singular", "value", "decomposition"] :> "SingularValueDecomposition.nb",
        "lsi" | "lsa" | FO["latent", "semantic", "indexing"] :> "LatentSemanticIndexing.nb",
        "pcfin" | FO["presidents", "choice", op["financial"]] :> "PresidentsChoice.nb",
        "itir" | FO["introduction", "to", "information", "retrieval"] :>
            "IntroductionToInformationRetrieval.nb",
        FO["livingston"] :> "Livingston.nb",
        "o4a" | "one4another" | FO["one", "4", "another"] :> "One4Another.nb",
        FO["sls"] :> "SLS.nb",
        "help bot" | "help chatbot" | "InstantHelp" | "ih" | FO["instant", "help"] :>
            "InstantHelp.nb",
        "TextStructure" | FO["text", "structure"] :> "TextStructure.nb",
        FO["help", "failures"] :> "HelpFailures.nb",
        AO[
            "semantic" | "semantics",
            FO["overlay", op["for wl" | "wl"] | FO[op["overlay"], "for wl" | "wl"]]
        ] :>
            "SemanticOverlayForWL.nb",
        AO["standalone", "java only parser" | "javaonlyparser" | "jop"] :>
            "StandaloneJavaOnlyParser.nb",
        FO["johnnie"] :> "Johnnie.nb",
        FO["astronomical", "ids"] :> "AstronomicalIDs.nb",
        FO["logistic", "regression"] :> "LogisticRegression.nb",
        FO["clustering"] :> "Clustering.nb",
        "eigen" | "eigenvectors" | "eigenvalues" | AO["eigenvectors", op["and"], "eigenvalues"] :>
            "EigenvectorsAndEigenvalues.nb",
        "dimred" | "dred" | FO["dimensionality", "reduction"] :> "DimensionalityReduction.nb",
        FO["dirichlet", op["distribution"]] :> "DirichletDistribution2.nb",
        "lda" | FO["latent", "dirichlet", "distribution"] :> "LatentDirichletAllocation.nb",
        "rideas" | FO["recurring", "ideas" | "themes"] :> "RecurringIdeas.nb",
        FO["homonymy" | "homonym" | "homonyms"] :> "Homonymy.nb",
        FO["metonymy"] :> "Metonymy.nb",
        FO["synonyms" | "synonym"] :> "Synonyms.nb",
        ("hyponymy" | "hyponym") | ("hypernymy" | "hypernym") :> "HyponymyAndHypernymy.nb",
        FO["log linear" | "log-linear" | FO["max" | "maximum", "entropy", "markov"], op["models"]] :>
            "LogLinearModels.nb",
        Alternatives[
            "afood",
            AO["food" | "fast food" | "restaurant", "automation" | "autonomous" | "automated"]
        ] :>
            "FastFoodAutomation.nb",
        FO["automation"] :> "Automation.nb",
        FO["part of speech" | "pos", "tagging" | "tags" | "tag"] :> "PartOfSpeechTagging.nb",
        FO["pos" | "part of speech" | "grammar" | "grammatical", "parsing" | "parser"] :>
            "PosParsing.nb",
        AO["stanford", op["coursera"], "nlp", op["course"]] :> "StanfordCourseraNlp.nb",
        "glm" | "glms" | FO["global", "linear", "models"] :> "GlobalLinearModels.nb",
        FO["discriminative" | "conditional", "models"] :> "DiscriminativeModels.nb",
        AO["generative" | "joint probability", "models" | "modeling"] :> "GenerativeModels.nb",
        "hmm" | "hmms" | FO["hidden", "markov", "models" | "model"] :> "HiddenMarkovModels.nb",
        Alternatives[
            "pcfgs",
            FO["probabilistic", "cfg" | "cfgs" | "context free grammar" | "context free grammars"]
        ] :>
            "PCFGs.nb",
        FO["trigger" | "triggers"] :> "Trigger.nb",
        FO["perceptron", op["algorithm"]] :> "PerceptronAlgorithm.nb",
        FO["dependency", "parsing"] :> "DependencyParsing.nb",
        "dvsc" | AO["discrete", "vs", "continuous" | "cont"] :> "DiscreteVsContinuous.nb",
        FO["crossing", "dependency" | "dependencies"] :> "CrossingDependency.nb",
        "bns" | FO["bayesian", "networks" | "network"] :> "BayesianNetworks.nb",
        FO["deep", "learning", op["for"], sym["$nlu"]] :> "DeepLearningForNLU.nb",
        "NER" | FO["named", "entity", "recognition"] :> "NamedEntityRecognition.nb",
        "word clusters" | "word cluster" | AO["distributional", "similarity", "word", "clusters"] :>
            "DistributionalSimilarityBasedWordClusters.nb",
        AO["stanford", "deep", "learning", "nlp", "video", "1"] :>
            "StanfordDeepLearningNlpVideo1.nb",
        FO["distributed", "representations"] :> "DistributedRepresentations.nb",
        FO["unsupervised", op["learning"]] :> "UnsupervisedLearning.nb",
        AO["unsupervised", sym["$nlu"], op["learning"]] :> "UnsupervisedNlp.nb",
        FO[
            "multi" | "multiple",
            "layer" | "layers" | "level" | "levels",
            op[FO[op["of"], "representation"] | "model" | "models"]
        ] :>
            "MultiLayerRepresentation.nb",
        Alternatives[
            "pre training",
            "pre-training",
            "pre training",
            FO["unsupervised", "pre training" | "pre-training" | "pretraining"]
        ] :>
            "UnsupervisedPreTraining.nb",
        "autoencoders" | FO["auto", "encoders"] :> "Autoencoders.nb",
        AO["stanford", "deep", "learning", sym["$nlu"], op["talks" | "lectures" | "videos"]] :>
            "StanfordDeepLearningNluCourse.nb",
        FO["supervised", op["learning"]] :> "SupervisedLearning.nb",
        FO["training", "data"] :> "TrainingData.nb",
        AO[
            op["finding"],
            "training",
            "data",
            op["via"],
            op["iteratively"],
            op["continuously"],
            "improving",
            op["model"]
        ] :>
            "FindingTrainingDataViaContinuouslyImprovingModel.nb",
        AO["automated" | "automating", "training", "data", op["discovery" | "gathering"]] :>
            "AutomatedTrainingData.nb",
        "maxent" | "max ent" | FO["maximum" | "max", "entropy" | "ent"] :> "MaximumEntropy.nb",
        FO["entropy"] :> "Entropy.nb",
        FO["softmax", op["layer"]] :> "Softmax.nb",
        "sigmoid" | FO["logistic" | "sigmoid", "function"] :> "LogisticFunction.nb",
        FO["online", "learning"] :> "OnlineLearning.nb",
        FO["batch", "learning"] :> "BatchLearning.nb",
        FO["gradient", "descent" | "ascent"] :> "GradientDescent.nb",
        FO["soft", "clustering"] :> "SoftClustering.nb",
        FO["hard", "clustering"] :> "HardClustering.nb",
        FO["neural", "word", "representation"] :> "NeuralWordRepresentation.nb",
        AO["compression", "vs", "modeling" | "learning" | "ai"] :> "CompressionVsModeling.nb",
        FO["brain"] :> "Brain.nb",
        FO["global", "probabilistic", "inferencer" | "inference"] :>
            "GlobalProbabilisticInferencer.nb",
        FO[
            "seesaw" | "see saw" | "see-saw" | "resonant",
            op["computation" | "solver" | "solving" | "inference"]
        ] :>
            "SeeSawComputation.nb",
        FO[
            "generating" | "producing" | "finding" | "discovering" | "computing",
            "word",
            "vectors"
        ] :>
            "GeneratingWordVectors.nb",
        FO["neural", "net" | "nets", "derivatives"] :> "NeuralNetDerivatives.nb",
        FO["derivatives"] :> "Derivatives.nb",
        AO["stanford", "deep", "learning", "nlp", "video", "2"] :>
            "StanfordDeepLearningNlpVideo2.nb",
        FO["phrase" | "sentence" | "clause" | "compositional", "vectors"] :> "PhraseVectors.nb",
        FO[sym["$ts"], "ranking" | "scoring" | "scores"] :> "TextSearchRanking.nb",
        FO[sym["$ts"], "java"] :> "TextSearchJava.nb",
        FO["nicolas" | "nicholas"] :> "Nicholas.nb",
        FO["bm25" | "bm 25"] :> "BM25.nb",
        FO["jcsat14" | "jcsat 14" | "jcsat"] :> "Jcsat14.nb",
        FO["rnn", op["word"], "vector", "parser" | "parsing"] :> "RnnVectorParser.nb",
        "bts" | FO["back", "propagation", "through", "structure"] :>
            "BackPropagationThroughStructure.nb",
        sym["$bp"] :> "Backpropagation.nb",
        FO["nc" | "non continuous" | "non-continuous", "objective", op["function"]] :>
            "NonContinuousObjectiveFunction.nb",
        FO["subgradient" | "sub gradient", "method"] :> "SubgradientMethod.nb",
        FO[
            "syntactically untied" | "syntactically-untied",
            op["rnn"],
            "vector",
            "parser" | "parsing"
        ] :>
            "SyntacticallyUntiedRnnVectorParser.nb",
        FO["compositional" | "composition", "vector", "grammar"] :>
            "CompositionalVectorGrammar.nb",
        "sp3" | FO["interdependent", sym["$nn"]] :> "SP3.nb",
        FO["factored", "parser"] :> "FactoredParser.nb",
        FO["classify"] :> "Classify.nb",
        FO["rnn", "paraphrase", "detection"] :> "RnnParaphraseDetection.nb",
        FO["paraphrase", "detection"] :> "ParaphraseDetection.nb",
        FO["lucene"] :> "Lucene.nb",
        Alternatives[
            FO["rename" | "renaming", op["a"], "symbol" | "symbols"],
            FO[
                "move",
                "functions" | "function" | "a function" | "symbol" | "symbols" | "a symbol",
                op[FO["between files" | FO["to", op["a"], op["new" | "different"], "file"]]]
            ]
        ] :>
            "MoveFunctionsToNewFile.nb",
        FO["notebook" | "notebooks", "creation" | "creating"] :>
            VaScore["NotebookCreation.nb", 0.9],
        FO["lucene", "searching"] :> "LuceneSearching.nb",
        FO["query", "fluffer" | "fluffing"] :> "QueryFluffing.nb",
        FO["local", "web server" | "webserver"] :> "LocalWebServer.nb",
        FO["wl" | "wolfram", "web", "apps" | "app"] :> "WLWebApps.nb",
        FO[op["lucene"], "query", op["class" | "classes"]] :> "QueryClass.nb",
        AO["sorted hash association" | "sha", "profiling" | "profile"] :>
            "SortedHashAssociationProfiling.nb",
        FO[op["new"], "hashfunction" | "hash", "slowdown"] :> "NewHashFunctionSlowdown.nb",
        AO["lucene", "searching" | "search"] :> "LuceneSearching.nb",
        FO[
            "query",
            "use cases" | "use cases" | "limiters" | "restrictions" | "features" | "parameters"
        ] :>
            "QueryUseCases.nb",
        FO["lucene", "scoring" | "scores" | "ranking" | "sorting"] :> "LuceneScoring.nb",
        FO["lucene", "concepts"] :> "LuceneConcepts.nb",
        Alternatives[
            "lucene comparison",
            AO[
                "lucene",
                "version" | "versions",
                op["feature" | "features"],
                op["comparison" | "compare"]
            ]
        ] :>
            "LuceneVersionComparison.nb",
        FO[
            op["lucene"],
            op["query"],
            "rescorer" | "rescoring" | "queryrescorer" | "rescore" | "reranking" | "rerank"
        ] :>
            "LuceneQueryRescorer.nb",
        Alternatives[
            AO["use" | "using", "Lucene", op["locally"]],
            AO["installing" | "install" | "installation", "lucene"]
        ] :>
            "InstallingLucene.nb",
        FO["java"] :> "Java.nb",
        "eclipse" | FO[op["wolfram"], "workbench"] :> "Workbench.nb",
        FO[op["workbench" | "eclipse"], "java", op["code"], "formatting"] :>
            "WorkbenchJavaFormatting.nb",
        FO["lucene", "play"] :> "LucenePlay.nb",
        "elasticsearch" | FO["elastic", "search"] :> "ElasticSearch.nb",
        "LearnPattern" | FO["learn", "pattern"] :> "LearnPattern.nb",
        FO["alpha"] :> "Alpha.nb",
        FO[op["java"], "deprecated" | "@deprecated"] :> "JavaDeprecated.nb",
        "ftools" | "functools" | "FunctionTools" | FO["function" | "func", "tools"] :>
            "Function Tools.nb",
        "inverse document frequency" | "idf" :> "idf.nb",
        FO[sym["$ts"], "ideas"] :> "TextSearchIdeas.nb",
        FO["classifier" | "classification"] :> "Classifier.nb",
        FO["extract" | "extracting", "term", "freq" | "frequencies" | "frequency"] :>
            "ExtractTermFreq.nb",
        "xxx" | FO["broken", "ling" | "linguistics"] :> "BrokenLinguistics.nb",
        FO["extracting" | "extract", op["data"], "from", "lucene"] :>
            "ExtractingDataFromLucene.nb",
        "CustomScoreQuery" | FO["custom", "score", "query"] :> "CustomScoreQuery.nb",
        "FunctionQuery" | FO["function", "query"] :> "FunctionQuery.nb",
        FO["joint", "probability", "equations" | "study"] :> "JointProbability2.nb",
        FO["feature", "extract" | "extraction"] :> "WlFeatureExtract.nb",
        "ltok" | FO["lucene", "tokenization"] :> "LuceneTokenization.nb",
        "SynonymFilter" | FO["synonym", "filter"] :> "SynonymFilter.nb",
        FO["lucene", "synonyms"] :> "LuceneSynonyms.nb",
        FO[op["lucene"], "query", "parser"] :> "LuceneQueryParser.nb",
        FO["stemming" | "stem"] :> "Stemming.nb",
        FO["lemmatisation" | "lematisation" | "lemmatization" | "lematization"] :>
            "Lemmatisation.nb",
        FO["lucene", "configuration" | "config" | "features"] :> "LuceneConfigFeatures.nb",
        FO[op["microsoft" | "ms" | "msft"], sym["$bot"], op["builder"]] :>
            "MicrosoftBotBuilder.nb",
        "FormFlow" | FO["form", "flow"] :> "FormFlow.nb",
        AO["linguistics" | "dialog", op["for"], "class" | "object" | "obj" | "entity"] :>
            "LinguisticsForClass.nb",
        FO["chatbot", "techniques" | "technologies" | "designs"] :> "ChatbotTechniques.nb",
        FO["luis"] :> "LUIS.nb",
        FO[op["year"], "2020"] :> "Year2020.nb",
        FO["year", "2028"] :> "Year2028.nb",
        "WeakReference" | FO["weak", "reference"] :> "WeakReference.nb",
        FO[op["spacex"], "mct bfr" | "bfr mct" | "bfr" | "mct"] :> "BfrMct.nb",
        "wdocs" | FO["wolfram" | "wl" | "m", "documentation" | "docs"] :> "wdocs.nb",
        Alternatives[
            "failed searches",
            "search failures",
            AO[op[sym["$wdocs"]], op["search"], "failures" | "failed"]
        ] :>
            "WolframDocsSearchFailurs.nb",
        FO[sym["$wdocs"], "failure", "categories" | "clusters" | "clustering"] :>
            "WdocsFailureCategories.nb",
        FO[
            op["lucene"],
            "token filters" | "TokenFilters" | "token filter" | "TextFilters" | "text filters"
        ] :>
            "LuceneTokenFilters.nb",
        AO[sym["$ts"], "usage" | "use"] :> "TextSearchUsage.nb",
        FO["eli"] :> "Eli.nb",
        FO["eli"] :> "Eli.nb",
        FO["tanh"] :> "tanh.nb",
        "MV-RNN" | "MV RNN" | FO[AO["matrix", op["-"], "vector"], "rnns"] :> "MatrixVectorRnns.nb",
        "sa" | FO["sentiment", op["analysis" | "detection"]] :> "SentimentAnalysis.nb",
        FO["relationship", "classification" | "classifier"] :> "RelationshipClassification.nb",
        "RNTN" | FO["recursive", "neural", "tensor", "network"] :>
            "RecursiveNeuralTensorNetwork.nb",
        FO["mechanical", "turk"] :> "MechanicalTurk.nb",
        FO[sym["$va"], "learning" | "learn", "synonyms"] :> "VaLearningSynonyms.nb",
        FO["chiara"] :> "Chiara.nb",
        FO["querying", "wdocs"] :> "QueryingWdocs.nb",
        FO["drag", "and", "drop"] :> "DragAndDrop.nb",
        FO["test", "notebook"] :> "TestNotebook.nb",
        FO["britannica", "ranking"] :> "BritannicaRanking.nb",
        FO["britannica" | "brit"] :> "Britannica.nb",
        FO["profiling" | "profile", sym["$ts"]] :> "ProfileJavaTextSearch.nb",
        FO["papers"] :> "Papers.nb",
        FO["universal", "dependencies" | "dependency" | "POS" | "POS tagset" | "POS tagsets"] :>
            "UniversalDependencies.nb",
        FO[sym["$multilang"], "word", "clusters" | "cluster"] :> "Cross-LingualWordClusters.nb",
        "malopa" | FO[sym["$multilang"], "parsing" | "parser"] :> "MultilingualParsing.nb",
        FO["many", "languages", "one", "parser"] :> "ManyLanguagesOneParser.nb",
        "djbts1" | FO["djb", sym["$ts"], "corpus", "1"] :> "DjbTextSearchCorpus1.nb",
        "nlm" | FO["neural", "language", "model" | "models"] :> "NeuralLanguageModel.nb",
        FO["rnn", "language", "model"] :> "RNNLanguageModel.nb",
        FO["learning", "word", "senses"] :> "LearningWordSenses.nb",
        AO["ontology", "learning", op["an"]] :> "OntologyLearning.nb",
        FO["overfitting"] :> "Overfitting.nb",
        FO["underfitting"] :> "Underfitting.nb",
        FO["nonlinearities" | "nonlinearity" | FO["non", op["-"], "linearities" | "linearity"]] :>
            "Nonlinearities.nb",
        FO[sym["$nn"], "parameter", "initialization"] :> "NNParameterInitialization.nb",
        "rbm" | FO["restricted", "boltzmann", "machines"] :> "RestrictedBoltzmannMachines.nb",
        "sgd" | FO["stochastic", "gradient", "descent"] :> "StochasticGradientDescent.nb",
        FO["lbfgs" | "l-bfgs"] :> "LBFGS.nb",
        FO["learning", "rate" | "rates"] :> "LearningRate.nb",
        "adagrad" | FO["ada", "grad"] :> "AdaGrad.nb",
        FO["regularization"] :> "Regularization.nb",
        FO["coadaptation" | "co-adaptation"] :> "coadaptation.nb",
        FO["dropout"] :> "Dropout.nb",
        FO["accomplishments"] :> "Accomplishments.nb",
        FO[sym["$ts"], "stemming"] :> "TsStemming.nb",
        FO[sym["$ts"], "camel case" | "CamelCase"] :> "TsCamelCase.nb",
        "WordDelimiterFilter" | "camel case filter" | FO["word", "delimiter", "filter"] :>
            "WordDelimiterFilter.nb",
        FO[op["lucene"], "analyzer"] :> "LuceneAnalyzer.nb",
        FO["lucene" | sym["$ts"], "tokenizer", "debugger"] :> "LuceneTokenizerDebugger.nb",
        AO[sym["$ts"], "features", op[FO["for", "ranking"]]] :> "TextSearchFeaturesForRanking.nb",
        FO["compression"] :> "Compression.nb",
        FO["compressing", sym["$nn"]] :> "CompressingNeuralNets.nb",
        "hauto" | "homeauto" | FO["home", "automation"] :> "HomeAutomation.nb",
        "dlearning" | "dl" | FO["deep", "learning"] :> "DeepLearning.nb",
        FO["convoluted"] :> "Convoluted.nb",
        FO["convolutional"] :> "Convolutional.nb",
        FO[sym["$ts"], op["+"] | "and", "featureextract" | "feature extract"] :>
            "TextSearch+FeatureExtract.nb",
        FO["my", "computer"] :> "MyComputer.nb",
        FO["symbolic representation" | "sr", "project" | "proj"] :> "SymbolicRepresentation.nb",
        FO["linguistic" | "nlu" | "nlp", "services" | "apis"] :> "LinguisticServices.nb",
        "qr" | FO["query", "recognizer"] :> "QueryRecognizer.nb",
        FO[sym["$ts"], "doc page" | "documentation page"] :>
            "E:\\Users\\Daniel\\Dropbox\\Wolfram\\Issues\\TextSearchMain\\DocumentationPages\\TextSearch.nb",
        "ContentObject" | FO["content", "object"] :> "ContentObject.nb",
        FO["tali" | "tali's", "tools" | "debugging tools"] :> "TaliTools.nb",
        FO["CreateSearchIndex" | "csi", "docs"] :>
            "E:\\Users\\Daniel\\Dropbox\\Wolfram\\Issues\\TextSearch\\DocumentationPages\\CreateSearchIndex.nb",
        FO["perceptron"] :> "Perceptron.nb",
        FO["sequence", "prediction"] :> "SequencePrediction.nb",
        FO["composition" | "compositional"] :> "Composition.nb",
        FO["yann" | "yan" | "lecun", op["yann" | "yan" | "lecun"]] :> "YannLecun.nb",
        "Microns project" | FO["mapping", "the", "brain", "to", "build", "better", "machines"] :>
            "MappingTheBrainToBuildBetterMachines.nb",
        FO["buzz", "phrases"] :> "BuzzPhrases.nb",
        "cortex" | FO["neocortex" | "neo cortex"] :> "Neocortex.nb",
        FO["microcircuits"] :> "Microcircuits.nb",
        FO["pluto"] :> "Pluto.nb",
        FO["visual", "cortex"] :> "VisualCortex.nb",
        FO["local", "minima" | "minimum" | "maxima" | "maximum"] :> "LocalMinima.nb",
        "cnn" | "cnns" | "ConvNet" | FO["convolutional", "neural", "network"] :>
            "ConvolutionalNeuralNetwork.nb",
        FO["relu" | "rectification"] :> "ReLU.nb",
        FO["google", "docs"] :> "GoogleDocs.nb",
        FO["year", "2035"] :> "Year2035.nb",
        FO["britannica", "tests" | "testing" | "failures"] :> "BritannicaTests.nb",
        FO[
            sym["$ts"],
            op["debug" | "debugging" | "dev" | "development"],
            "tools" | "debugging" | "debug"
        ] :>
            "TextSearchTools.nb",
        FO[sym["$ts"], "issues" | "bugs"] :> "TextSearchIssues.nb",
        FO[sym["$ts"], "links"] :> "TextSearchLinks.nb",
        FO[sym["$ts"], "bad", "ranking", op["examples"]] :> "TextSearchBadRankingExamples.nb",
        FO["lucene", op["search" | "score" | "scoring"], "explain" | "explanation"] :>
            "LuceneExplain.nb",
        FO["lucene", "scoring" | "ranking" | "sorting", "learnings"] :>
            "LuceneScoringLearnings.nb",
        FO["new" | "creating" | "configure" | "configuring", op["a"], "project" | "package"] :>
            "NewProject.nb",
        Alternatives[
            "context of symbol",
            "contexts of symbols",
            "resolving symbols",
            FO["symbol", "to", "context"]
        ] :>
            "SymbolToContext.nb",
        FO["symbol", op["to"], "file", op["mapping"]] :> "SymbolToFileMapping.nb",
        FO["v11"] :> "V11.nb",
        FO["space", "hotel" | "hotels"] :> "SpaceHotel.nb",
        FO["ba", op["-"], "330"] :> "BA330.nb",
        FO["launch", "cadence"] :> "LaunchCadence.nb",
        FO["deep", "learning", "textbook"] :> "DeepLearningTextbook.nb",
        "javadoc" | FO["java", "doc"] :> "JavaDoc.nb",
        FO["satellite", "servicing"] :> "SatelliteServicing.nb",
        FO["classification"] :> "Classification.nb",
        AO["debugging" | "debug", "lucene", "queries" | "query"] :> "DebuggingLuceneQueries.nb",
        FO[sym["$ts"] | "search", "evaluation"] :> "SearchEvaluation.nb",
        FO[op["old"], "diffs"] :> "OldDiffs.nb",
        Alternatives[
            "sausagenization",
            FO[
                op["lucene"],
                "synonym" | "tokenization",
                "issue" | "issues" | "problem" | "problems" | "bug" | "bugs" | "limitations"
            ]
        ] :>
            "LuceneSynonymIssues.nb",
        FO["semantic" | "document", "tagger"] :> "DocumentTagger.nb",
        AO["formatted" | "format" | "formatting" | "tool", "score", "explanation" | "summary"] :>
            "FormattedScoreExplanation.nb",
        AO[sym["$ts"], sym["$lang"] | "languages", op["support" | "support for"]] :>
            "TextSearchLanguageSupport.nb",
        FO[sym["$ts"], "synonym" | "synonyms", op["support"]] :> "TextSearchSynonymSupport.nb",
        FO["should"] :> "Should.nb",
        FO["lizzie" | "lizie" | "liz" | "eturner"] :> "Lizzie.nb",
        FO[sym["$ts"], "filename"] :> "TextSearchFileName.nb",
        Alternatives[
            "alsynonyms",
            AO["Synonyms", op["From"], "al" | FO["Alpha", "Linguistics" | "linguistic"]]
        ] :>
            "SynonymsFromAlphaLinguistics.nb",
        AO["symbolists" | "symbolist", "vs", "connectionists" | "connectionist"] :>
            "SymbolistsVsConnectionists.nb",
        AO[
            "synergizing" | "synergy",
            "discrete" | "symoblic",
            op["and" | "vs"],
            "continuous" | "differentiable",
            op["models" | "ai" | "intelligence"]
        ] :>
            "SynergizingDiscreteAndContinuousModels.nb",
        FO["events"] :> "Events.nb",
        "e" | FO["eutelsat", op["-"], op["abs"], op["-"], op["2"]] :> "EutelsatAbs2.nb",
        AO["synonyms" | "synonym", op["via"], "query", "expansion"] :>
            "SynonymsViaQueryExpansion.nb",
        AO[op["running"], sym["$ts"], "tests" | "testing"] :> "TextSearchTests.nb",
        FO["jenkins" | "jenkens"] :> "Jenkins.nb",
        FO["ngparser", "proposal"] :> "NGParserProposal.nb",
        FO[sym["$ts"], "sw" | "stephen", op["discussion" | "discussion points" | "items"]] :>
            "TextSearchSWDiscussionPoints.nb",
        FO["sw", "meetings" | "meeting"] :> "SWMeetings.nb",
        FO["autocomplete"] :> "Autocomplete.nb",
        FO["trampoline"] :> "Trampoline.nb",
        FO[op["wl" | "m" | "mathematica"], "layout" | "ui"] :> "Layout.nb",
        "Dynamic" | "DynamicModule" | FO["dynamic", "module"] :> "DynamicModule.nb",
        FO["framed" | "frame" | "frames"] :> "Framed.nb",
        "ubi" | FO[op["universal"], "basic", "income"] :> "BasicIncome.nb",
        FO[sym["$ng"], "use cases" | "project ideas"] :> "NgUseCases.nb",
        FO["simple", "clauses" | "clause"] :> "SimpleClauses.nb",
        "fieldNorm" | FO["field", "length", "normalization" | "norm"] :>
            "FieldLengthNormalization.nb",
        FO[op["lucene" | sym["$ts"]], "similarity", op["class"]] :> "Similarity.nb",
        FO["bm25similarity"] :> "BM25Similarity.nb",
        FO["search", "maintenance" | "maint"] :> "SearchMaintenance.nb",
        FO[sym["$ts"], "todo" | "todos"] :> "TextSearchTodo.nb",
        FO[op["return"], "sub match" | "submatch", "data"] :> "ReturnSubMatchData.nb",
        FO["projective" | "projection", op["parsing" | "dependency" | "dependencies"]] :>
            "ProjectiveParsing.nb",
        "meetings" | "meeting" | FO["meeting", "notes"] :> "MeetingNotes.nb",
        FO["interpreter"] :> "Interpreter.nb",
        FO[sym["$ts"], op["+"], "email"] :> "TextSearch+Email.nb",
        FO["dev proto" | "devproto" | "xkernel"] :> "XKernel.nb",
        FO["lucene", "autocomplete"] :> "LuceneAutocomplete.nb",
        FO["nutch"] :> "Nutch.nb",
        FO["ivy"] :> "Ivy.nb",
        FO["wolframsearch" | "wolfram search", op["webapp"]] :> "WolframSearchWebapp.nb",
        FO["new", "search", "system" | "app"] :> "NewSearchSystem.nb",
        "web crawler" | FO[op["web"], "crawler"] :> VaScore["WebCrawler.nb", 0.9],
        FO["search", "library"] :> "SearchLibrary.nb",
        FO["search.wolfram.com" | "search.wolfram"] :> "search.wolfram.com.nb",
        FO["reference.wolfram.com" | "reference.wolfram"] :> "reference.wolfram.com.nb",
        FO[op["apache"], "velocity"] :> "ApacheVelocity.nb",
        FO[sym["$markov"], op["classify"], "qa", op["documentation" | "doc" | "docs"]] :>
            "QADocumentation.nb",
        FO["contentobject", "slowness"] :> "ContentObjectSlowness.nb",
        Alternatives[
            "tsfd",
            "tsod",
            "tsfod",
            FO[sym["$ts"], "FieldOptions" | "field options" | "field option", "design"]
        ] :>
            "TextSearchFieldOptionsDesign.nb",
        FO["filename", op["field"], "tokenized" | "tokenization"] :> "FileNameFieldTokenized.nb",
        FO["file", "reload" | "reloading", "ui"] :> "FileReloadUi.nb",
        "alphasource" | FO["alpha", "source"] :> "AlphaSource.nb",
        FO[sym["$ts"], op["automatic"], sym["$lang"], "detection" | "selection"] :>
            "TextSearchAutomaticLanguageDetection.nb",
        "LanguageIdentify" | FO["language", "identify"] :> "LanguageIdentify.nb",
        FO["reinforcement", op["learning"]] :> "ReinforcementLearning.nb",
        "mdp" | FO["markov", "decision", "process" | "processes"] :> "MarkovDecisionProcess.nb",
        FO["denoising" | "denoise" | "noise", "autoencoders" | "autoencoder"] :>
            "DenoisingAutoencoders.nb",
        FO[
            "sequence to sequence" | "sequence-to-sequence" | "rnn",
            "autoencoders" | "autoencoder"
        ] :>
            "SequenceToSequenceAutoencoders.nb",
        FO["variational", "autoencoders" | "autoencoder"] :> "VariationalAutoencoders.nb",
        FO["generative", "adversarial", "networks" | "network"] :>
            "GenerativeAdversarialNetworks.nb",
        FO["lucene" | sym["$ts"], "spelling", "correction"] :> "LuceneSpellingCorrection.nb",
        FO[sym["$ts"], "+" | "plus" | "and", sym["$cloud"]] :> "TextSearch+Cloud.nb",
        "mcmc" | FO[op["markov"], op["chain"], "monte", "carlo"] :> "MarkovChainMonteCarlo.nb",
        FO["markov", "chain" | "chains"] :> "MarkovChain.nb",
        FO["ai" | "ml" | "intelligence", "people"] :> "AIPeople.nb",
        FO["pcw", "meetings" | "meeting"] :> "PCWMeetings.nb",
        AO["pwc", op[sym["$ts"]]] :> "PWC.nb",
        "SpanNearQuery" | FO["span", "near", "query"] :> "SpanNearQuery.nb",
        FO["lucene", "mailing" | "email" | "mail", op["list"]] :> "LuceneMailingList.nb",
        FO[op["lucene"], "query", "expansion"] :> "LuceneQueryExpansion.nb",
        "SynonymQuery" | FO["synonym", "query"] :> "SynonymQuery.nb",
        "LuceneTokenize" | "ltokenize" | FO["lucene", "tokenize"] :> "LuceneTokenize.nb",
        "devts" | "DevTextSearch" | FO["dev", sym["$ts"]] :> "DevTextSearch.nb",
        FO[sym["$new2"], "lucene" | sym["$ts"], "index"] :> "CreateLuceneIndex.nb",
        FO[op[sym["$ts"]], op["field"], "types" | "type"] :> "TextSearchFieldTypes.nb",
        FO[op[sym["$ts"]], "field", "options" | "attributes" | "settings"] :>
            "TextSearchFieldOptions.nb",
        FO["createFieldDefintionX"] :> "createFieldDefintion.nb",
        FO["thaicom" | "thiacom", op["8"]] :> "Thaicom8.nb",
        FO["status"] :> "Status.nb",
        AO["mars", sym["$spacex"]] | AO["red", "dragon", op["mars"]] :> "RedDragon.nb",
        "f9" | FO["falcon", "9"] :> "Falcon9.nb",
        FO["lawn" | "yard" | "grass", op["maintenance"]] :> "LawnMaintenance.nb",
        FO[op["past" | "previous" | "old"], op[sym["$spacex"]], "flights" | "launches"] :>
            "PastFlights.nb",
        FO[op[sym["$spacex"]], op["falcon"], op["9"], "landings"] :> "SpaceXLandings.nb",
        "crs9" | FO["crs", "9"] :> "CRS9.nb",
        FO[sym["$ts"], "to", "document"] :> "TextSearchToDocument.nb",
        AO["java", "profiling" | "profile"] :> "JavaProfiling.nb",
        FO["dryer"] :> "Dryer.nb",
        "reading" | "reading list" | FO["to", op["be"], "read"] :> "ToRead.nb",
        FO["notebooks" | "notebook", op["howto" | "how to"]] :> "Notebooks.nb",
        AO["simple" | "example", "lucene", "indexer"] :> "SimpleLuceneIndexer.nb",
        FO[op["notebook"], "kb" | "knowledge base"] :> "NotebookKnowledgeBase.nb",
        FO["local2"] :> "Local2.nb",
        FO[sym["$va"], "icon"] :> "VirtualAssistantIcon.nb",
        "bopt" | FO["bayesian", "optimization"] :> "BayesianOptimization.nb",
        "learning" | AO["to" | "todo", op["be"], "learn" | "learned" | "learning"] :> "ToLearn.nb",
        FO["gaussian", "process" | "processes"] :> "GaussianProcess.nb",
        FO["acquisition", "function"] :> "AcquisitionFunction.nb",
        AO["exploration", "vs", "exploitation"] :> "ExplorationVsExploitation.nb",
        AO["update", "search", "index"] :> "UpdateSearchIndex2.nb",
        FO["testhead"] :> "TestHeadWrapper.nb",
        FO[sym["$ts"], "data sets" | "corpus" | "corpora" | "corpi"] :> "TextSearchDataSets.nb",
        FO[sym["$ts"], "failures" | "bugs" | "failing inputs"] :> "TextSearchFailures.nb",
        FO[sym["$run"], sym["$ts"], "tests", "2"] :> "RunTextSearchTests.nb",
        FO[sym["$ts"], "done" | "accomplishments", op["reports" | "report"]] :>
            "TextSearchDoneReports.nb",
        FO["landed", "stages" | "first stages" | "rockets" | "falcon 9s"] :> "LandedStages.nb",
        AO["building" | "compiling" | "build", sym["$ts"]] :> "BuildingTextSearch.nb",
        FO[sym["$va"], "usage"] :> "VirtualAssistantUsage.nb",
        FO[sym["$ml"], "standalone" | "stand alone" | "alone"] :> "MachineLearningStandalone.nb",
        FO["code", "captions" | "caption"] :> "CodeCaptions.nb",
        "cct" | FO["code", "caption", "translations" | "trans" | "transl"] :>
            "CodeCaptionTranslations.nb",
        FO[sym["$ts"], op["+"], "eiwl"] :> "TextSearch+EIWL.nb",
        FO["viv"] :> "Viv.nb",
        FO["viv", "primiere"] :> "VivPrimiere.nb",
        FO[
            "wolfram documentation" | "wdoc" | "wdocs",
            "translations" | "translation",
            "for",
            "search"
        ] :>
            "WolframDocumentationTranslationsForSearch.nb",
        FO[sym["$ts"], "fixedorder" | "fo", op[FO["+", "alternatives" | "alt"]], op["support"]] :>
            "TextSearchFixedOrder+AlternativesSupport.nb",
        FO["jira"] :> "Jira.nb",
        Alternatives[
            FO[sym["$ts"], "file" | "doc" | "document" | "documents", "collection" | "collections"],
            FO["collections", "of", "docs" | "documents"]
        ] :>
            "FilesThatAreCollectionsOfDocuments.nb",
        "image recognition" | FO["computer", "vision"] :> "ComputerVision.nb",
        FO[sym["$spacex"], "data"] :> "SpaceXData.nb",
        FO["json", op["-"], "ld"] :> "JSON-LD.nb",
        "resource description framework" | FO["rdf"] :> "RDF.nb",
        "friend of a friend" | FO["foaf"] :> "FOAF.nb",
        FO["bm25", "hookup"] :> "BM25Hookup.nb",
        "CloudExpression" | FO["cloud", "expression"] :> "CloudExpression.nb",
        FO["ub", "json"] :> "UbJson.nb",
        FO["fields", "containing", "lists"] :> "FieldsContainingLists.nb",
        AO["null" | "nulls", op["values"], op["in"], GrammarToken["$ts"], op["fields"]] :>
            "NullValuesInTextSearchFields.nb",
        FO["clucene"] :> "CLucene.nb",
        "htm" | FO["hierarchical", "temporal", "memory"] :> "HierarchicalTemporalMemory.nb",
        FO["createsearchindex" | "csi", "options" | "opt" | "opts"] :>
            "CreateSearchIndexOptions.nb",
        "SyntaxNet" | FO["syntax", "net"] :> "SyntaxNet.nb",
        "parsey" | "mcparseface" | FO["parsey", "mcparseface"] :> "ParseyMcParseface.nb",
        FO["universal", "treebanks" | "treebank", "project"] :> "UniversalTreebanksProject.nb",
        "sherpa" | FO["formosat"] :> "Formosat.nb",
        FO[sym["$ts"], op["tunable"], "parameters" | "params"] :> "TextSearchTunableParameters.nb",
        FO[sym["$ts"], "synonyms" | "synonym" | "syn", sym["$impl"]] :>
            "TextSearchSynonymsImplementation.nb",
        AO[
            "fairing" | "fairing" | "fairings",
            "reusability" | "reuse" | "reusing" | "recovery" | "recovering"
        ] :>
            "FairingReusability.nb",
        FO["lucene", "bugs"] :> "LuceneBugs.nb",
        "SearchResultObject" | "search result object" | FO[sym["$ts"], "result", "object" | "obj"] :>
            "TextSearchResultObject.nb",
        FO[sym["$ts"], "gaps" | "gap" | "slop"] :> "TextSearchGaps.nb",
        FO[op[sym["$new"]], "system", "symbol" | "symbols"] :> "NewSystemSymbol.nb",
        FO["neo4j"] :> "Neo4j.nb",
        FO["graph", "databases" | "database" | "db" | "dbs"] :> "GraphDatabases.nb",
        FO["api.ai"] :> "api.ai.nb",
        FO["api.ai", op["and" | "+"], "slack", op["integration"]] :> "Api.aiSlack.nb",
        FO["download", "lucene", op["source" | "src"]] :> "DownloadLucene.nb",
        FO["building" | "build", "lucene"] :> "BuildingLucene.nb",
        FO[sym["$ts"], "import", "failures" | "failure"] :> "TextSearchImportFailures.nb",
        sym["$mye"] :> "MyEntities.nb",
        FO["lists", op["that"], "contain" | "containing", "null"] :> "ListsThatContainNull.nb",
        FO[sym["$mye"], "ideas"] :> "MyeIdeas.nb",
        FO["create", op["new"], "project"] :> "CreateProject.nb",
        FO["file", "reloading"] :> "FileReloading.nb",
        FO[sym["$mye"], "types"] :> "MyeTypes.nb",
        "myep" | "myeprop" | FO["mye", "properties" | "prop"] :> "MyeProperties.nb",
        FO["make", "symbol", "public"] :> "MakeSymbolPublic.nb",
        "myei" | "mye inst" | "myeinst" | FO[sym["$mye"], "instances" | "instance"] :>
            "MyeInstances.nb",
        FO["flexible", "query", "parser"] :> "FlexibleQueryParser.nb",
        FO["our" | "wolfram", "query", "parser"] :> "OurQueryParser.nb",
        FO["mini", "parser"] :> "MiniParser.nb",
        "tsqp" | FO[sym["$ts"], "query", "parser"] :> "TextSearchQueryParser.nb",
        "sk" | "skel" | FO["skeletonizer"] :> "Skeletonizer.nb",
        FO[sym["$skel"], "notes"] :> "SkeletonizerNotes.nb",
        "DocumentationBuild" | FO["documentation", "build"] :> "DocumentationBuild.nb",
        "wld" | "WolframLanguageData" | FO["wolfram", "language", "data"] :>
            "WolframLanguageData.nb",
        FO[sym["$ts"], op["on"], sym["$cloud"]] :> "TextSearchCloud.nb",
        FO["monitor"] :> "Monitor.nb",
        FO[sym["$ts"], sym["$cloud"], "tests" | "testing"] :> "TextSearchCloudTests.nb",
        FO["ula"] :> "ULA.nb",
        "dragon 2" | FO["crew", "dragon"] :> "CrewDragon.nb",
        "jwst" | FO["james", "webb", "telescope"] :> "JamesWebbTelescope.nb",
        Alternatives[
            FO["loc" | "location", "transf" | "transformation", op["func" | "function"]],
            "IndexURIFunction",
            FO[op["index"], "uri" | "url", "function"]
        ] :>
            "IndexURIFunction.nb",
        FO[sym["$ts"], "metadata"] :> "TextSearchMetadata.nb",
        FO["symbol", "suboptions" | "sub options"] :> "SymbolSubOptions.nb",
        FO[sym["$ts"], "autocomplete"] :> "TextSearchAutocomplete.nb",
        AO["restricted", op["+"], "autocomplete"] :> "RestrictedAutocomplete.nb",
        FO[op["searchadjustment" | "searchadj"], "weight", op["second"], "argument" | "arg"] :>
            "WeightSecondArgument.nb",
        FO["cloud"] :> "Cloud.nb",
        "wifi" | FO["wi", op["-"], "fi"] :> "Wi-Fi.nb",
        FO[op[sym["$ts"]], "boost" | "weight" | "weights", "documents" | "doc"] :>
            "BoostDocuments.nb",
        FO[sym["$mye"], "tasks" | "todo"] :> "MyeTasks.nb",
        FO[sym["$mye"], sym["$ling"]] :> "MyeLinguistic.nb",
        FO[sym["$mye"], "basic", sym["$ling"]] :> "MyeBasicLinguistics.nb",
        FO[sym["$va"], "autocomplete"] :> "VAAutocomplete.nb",
        FO[sym["$mye"], sym["$spacex"], "data"] :> "MyeSpaceXData.nb",
        FO["air", "taxi"] :> "AirTaxi.nb",
        FO["droneship" | "asds" | "ocisly", "eta"] :> "DroneshipETA.nb",
        AO["automated" | "automation", sym["$ts"], "testing" | "tests"] :>
            "AutomatedTextSearchTesting.nb",
        FO[sym["$ts"], "qa"] :> "TextSearchQA.nb",
        FO[op[sym["$ts"]], op["change"], "log", sym["$nb"]] :> "TextSearchChangeLog.nb",
        FO[sym["$ts"], op["release"], "merge" | "merging" | "merges"] :>
            "TextSearchReleaseMerge.nb",
        FO["java", op[sym["$ts"]], "default"] :> "MakeJavaTextSearchDefault.nb",
        FO[sym["$ts"], op["document" | "doc" | "file"], "formats"] :>
            "TextSearchDocumentFormats.nb",
        FO[sym["$ts"], "html", op["importing" | "import"]] :> "TextSearchHTMLImporting.nb",
        FO[sym["$ts"], "documentation" | "doc"] :> "TextSearchDocumentation.nb",
        FO["biotech" | "bio" | "health" | "biology"] :> "Biotech.nb",
        FO["talking", "timer"] :> "TalkingTimer.nb",
        FO["broken", "tests"] :> "BrokenTests.nb",
        AO[op["git"], op["stash"], "cherry", "picking"] :> "CherryPicking.nb",
        FO[sym["$ts"], "play" | FO["try", "stuff" | "things"]] :> "TextSearchPlay.nb",
        FO["arguments"] :> "Arguments.nb",
        "ContentLocationFunction" | FO["content", "location", "function"] :>
            "ContentLocationFunction.nb",
        FO[sym["$notebook"], "to", "markdown" | "md"] :> "NotebookToMarkdown2.nb",
        FO["crs", op["-"], "11"] :> "CRS11.nb",
        "wtc" | FO[op["wolfram"], "technology" | "tech", "conference"] :>
            "WolframTechnologyConference.nb",
        "disability insurance" | FO["insurance"] :> "Insurance.nb",
        AO[sym["$ts"], op["cloud"], "public", "kernels" | "kernel"] :>
            "TextSearchPublicKernels.nb",
        FO["releases" | "release", op["date" | "dates"]] :> "Releases.nb",
        FO["maluuba"] :> "Maluuba.nb",
        FO["changing" | "change", "branches" | "branch"] :> "ChangingBranches.nb",
        "wplugin" | FO["workbench", "plugin"] :> "WorkbenchPlugin.nb",
        "docutools" | FO["docu", "tools"] :> "DocuTools.nb",
        FO["landing", "attempts"] :> "LandingAttempts.nb",
        FO["download", "all"] :> "DownloadAll.nb",
        "kj" | "kij" | FO["kijiji"] :> "Kijiji.nb",
        FO["skeletonizing" | "skel", "guide" | "guides", op["pages"]] :>
            "SkeletonizingGuidePages.nb",
        FO["skeletonizer", "notebook", "types"] :> "SkeletonizerNotebookTypes.nb",
        FO["company", "meetings"] :> "CompanyMeetings.nb",
        FO["references"] :> "References.nb",
        FO[sym["$wdocs"], op["test"], "queries"] :> "WdocsTestQueries.nb",
        FO[
            sym["$wdocs"],
            "improvements" | "improve" | "improved" | "better",
            op["query" | "queries"]
        ] :>
            "WdocsImprovements.nb",
        FO[
            sym["$wdocs"],
            "regressions" | "regressed" | "worse" | "degraded" | "harmed",
            op["query" | "queries"]
        ] :>
            "WdocsRegressions.nb",
        FO[op["oop"], "interfaces"] :> "Interfaces.nb",
        FO["notebook", "defs"] :> "NotebookDefs.nb",
        FO["code"] :> "Code.nb",
        FO["testing", "tools"] :> "TestingTools.nb",
        FO["cottage"] :> "Cottage.nb",
        "cf" | "copyf" | FO["copy", "function" | "func"] :> "CopyFunction.nb"
    }